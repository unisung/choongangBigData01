package org.zerock.controller;

import java.io.File;
import java.io.IOException;

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
		
		for(MultipartFile multipart: uploadFile) {
			log.info("----------------------------------");
			log.info("upload File Name: " + multipart.getOriginalFilename());
			log.info("upload File Size: "+multipart.getSize());
			
			File saveFile = new File(uploadDir, multipart.getOriginalFilename());
			
			try {
				   multipart.transferTo(saveFile);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
