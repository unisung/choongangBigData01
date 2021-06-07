package org.zerock.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

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
			File saveFile = new File(uploadPath, uploadFileName);

			try {
				   multipart.transferTo(saveFile);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
 //c:\\upload폴더 아래 yyyy/MM/dd폴더 생성
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
	
}
