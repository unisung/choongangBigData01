package org.zerock.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

//@Controller
@Log4j
public class UploadController_old {
	
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
	
	@PostMapping("/uploadAjaxAction")
	public void uploadAjaxAction(MultipartFile[] uploadFile) {
		log.info("upload ajax post.........");
		
		String uploadDir = "c:\\upload";
		
		//maker folder
		File uploadPath = new File(uploadDir, getFolder());
		log.info("upload path: "+uploadPath);
		
    if(uploadPath.exists()==false) {uploadPath.mkdirs();}// yyyy/MM/dd folder 생성 로직
		
		for(MultipartFile multipart: uploadFile) {
			log.info("----------------------------------");
			log.info("upload File Name: " + multipart.getOriginalFilename());
			log.info("upload File Size: "+multipart.getSize());
			
			String uploadFileName = multipart.getOriginalFilename();
			
			// IE 
			uploadFileName = 
			uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			
			log.info("파일명: "+uploadFileName);
			
			//업로드된 파일명 중복처리
			UUID uuid = UUID.randomUUID();
			
			uploadFileName = uuid.toString()+"_"+uploadFileName;
			
			log.info("uuid-uploadFileName: "+uploadFileName);
			
			//File saveFile = new File(uploadDir, multipart.getOriginalFilename());
			
			try {
			File saveFile = new File(uploadPath, uploadFileName);
			
			///썸네일 생성
			if(checkImageType(saveFile))
			{
				//썸네일 저장할 경로로 OutputStream생성
				FileOutputStream thumbnail =
						new FileOutputStream(new File(uploadPath, "s_"+uploadFileName));
				//전송된 이미지파일로 입력스트림을 생성하고, 
				//생성된 OutputStream으로 가로:세로 100:100 크기의 이미지 생성
				Thumbnailator.createThumbnail(multipart.getInputStream(), thumbnail, 100,100);
				
				thumbnail.close();//자원해제
			}
			try {
				   multipart.transferTo(saveFile);
			}catch(Exception e) {
				e.printStackTrace();
			}
		  }catch(Exception e) {e.printStackTrace();}
		}
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
			    return contentType.startsWith("image");
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
}
