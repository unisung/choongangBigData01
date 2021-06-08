package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class UploadController {
	
	@GetMapping("/uploadForm")
	public void uploadForm() {log.info("uploadForm");}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormAction(MultipartFile[] uploadFile, Model model) {
		
		/*  파일 저장 */
		String uploadFolder = "c:\\upload";//저장폴더

		for(MultipartFile multipartFile : uploadFile) {
			 log.info("---------------------------------------------");
			 log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			 log.info("Upload File Size: " + multipartFile.getSize());
			 
			 File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			 
			 try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("upload ajax");
	}
	
	@PostMapping(value="/uploadAjaxAction", 
			               produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxAction(MultipartFile[] uploadFile) {
		log.info("upload ajax post.........");
		
		AttachFileDTO attachFileDTO = null;
		
		String uploadDir = "c:\\upload";
		//폴더경로 2021\\6\\07 정보
		String uploadFolderPath = getFolder();
		
		List<AttachFileDTO> list=new ArrayList<AttachFileDTO>();
		
		//maker folder
		File uploadPath = new File(uploadDir, uploadFolderPath);
		log.info("upload path: "+uploadPath);
		
    if(uploadPath.exists()==false) {uploadPath.mkdirs();}// yyyy/MM/dd folder 생성 로직
		
		for(MultipartFile multipart: uploadFile) {
			   
			attachFileDTO = new AttachFileDTO();
			
			log.info("----------------------------------");
			log.info("upload File Name: " + multipart.getOriginalFilename());
			log.info("upload File Size: "+multipart.getSize());

			String uploadFileName = multipart.getOriginalFilename();

			// IE 
			uploadFileName = 
					uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			
			//upload된 파일명변경 전에 파일명 설정
			attachFileDTO.setFileName(uploadFileName);
			
			
			log.info("파일명: "+uploadFileName);
			
			//업로드된 파일명 중복처리
			UUID uuid = UUID.randomUUID();
			
			uploadFileName = uuid.toString()+"_"+uploadFileName;
			
			log.info("uuid-uploadFileName: "+uploadFileName);
			

			//File saveFile = new File(uploadDir, multipart.getOriginalFilename());
			try {
			File saveFile = new File(uploadPath, uploadFileName);
			attachFileDTO.setUuid(uuid.toString());
			attachFileDTO.setUploadPath(uploadFolderPath);//getFolder()에 의해 얻어온 경로
			
			/*
			 * attachFileDTO.setUploadPath(uploadDir);
			 */			
		
			///썸네일 생성
			if(checkImageType(saveFile))
			{
				attachFileDTO.setImage(true);

				//썸네일 저장할 경로로 OutputStream생성
				FileOutputStream thumbnail =
						new FileOutputStream(new File(uploadPath, "s_"+uploadFileName));
				//전송된 이미지파일로 입력스트림을 생성하고, 
				//생성된 OutputStream으로 가로:세로 100:100 크기의 이미지 생성
				Thumbnailator.createThumbnail(multipart.getInputStream(), thumbnail, 100,100);
				
				thumbnail.close();//자원해제
			}
			  //list에 저장
			System.out.println("attachFileDTO:  "+attachFileDTO);   
			list.add(attachFileDTO);

			try {
				   multipart.transferTo(saveFile);
				   
			}catch(Exception e) {
				e.printStackTrace();
			}
		  }catch(Exception e) {e.printStackTrace();}
		}//for문 끝.
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName) {

		log.info("fileName: " + fileName);

		File file = new File("c:\\upload\\" + fileName);

		log.info("file: " + file);

		ResponseEntity<byte[]> result = null;

		try {
			HttpHeaders header = new HttpHeaders();

			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
/* download 처리 */
	@GetMapping(value="/download", 
			       produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent,
    		String fileName){
		log.info("download file: " + fileName);
		Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
		
		log.info("resource: "+resource);
		
		
		HttpHeaders headers = new HttpHeaders();
		
		//download할 자원이 없으면 NOT_FOUND 메세지 출력
		if(resource.exists()==false) {
			 return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		//download할 자원이 있으면 파일명 얻기
		String resourceName = resource.getFilename();
		
		//uuid제거
		//downoald시 파일명을 원래 업로드시 파일명으로 변환하도록 처리
		String resourceOriginalName = resourceName.substring(resourceName.lastIndexOf("_")+1);
		
		log.info("resourceOriginalName: "+resourceOriginalName);
		try {
			    //IE 한글깨짐 방지 처리
			    String downloadName=null;
			    
			    if(userAgent.contains("Trident")) {
			    	log.info("IE browser");
			    	downloadName = URLEncoder.encode(resourceOriginalName,"UTF-8").replaceAll("\\"," ");
			    }else if(userAgent.contains("Edge")) {
			    	log.info("Edge browser");
			    	downloadName = URLEncoder.encode(resourceOriginalName,"UTF-8");
			    }else {
			    	 log.info("Chrome browser");
			    	 downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
			    }
			    log.info("downloadName: " +downloadName);
				
				 // headers.add("Content-Disposition","attachment; filename=" 
				 //    + new String(resourceName.getBytes("UTF-8"),"ISO-8859-1"));
			    
			    headers.add("Content-Disposition","attachment; filename="+downloadName); 
		      }catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}

//파일삭제처리
@PostMapping("/deleteFile")
@ResponseBody
public ResponseEntity<String> deleteFile(String fileName, String type){
	log.info("deleteFile: " + fileName);
	
	File file;
	try {
		
		   file = new File("c:\\upload\\" +URLDecoder.decode(fileName, "UTF-8"));
		   
		   file.delete();
		   
		   if(type.equals("image")) {
			   String largeFileName = file.getAbsolutePath().replace("s_","");
			   log.info("largeFileName: " + largeFileName);
			   
			   file = new File(largeFileName);
			   file.delete();
		   }
	}catch(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<String>("deleted",HttpStatus.OK);
}
	
 //c:\\upload폴더 아래 yyyy/MM/dd폴더 생성
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
	
	//전송된 파일의 이미지 파일 여부 확인 메소드
	private boolean checkImageType(File file) {
		try {
			    String contentType=Files.probeContentType(file.toPath());
			    System.out.println("contentType: " +contentType);
			    
			    return contentType==null?false:contentType.startsWith("image");
			    
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
}
