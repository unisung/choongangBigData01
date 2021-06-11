package org.zerock.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.zerock.domain.BoardAttachVO;
import org.zerock.mapper.BoardAttachMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class FileCheckTask {
	
	@Setter(onMethod_=@Autowired)
	private BoardAttachMapper attachMapper;
	
	/* 전날의 날짜에 해당하는 폴더 정보 얻기 */
	public String getFolderYesterDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DATE, -1);
		
		String str = sdf.format(cal.getTime());
		
		return str.replace("-",File.separator);//yyyy\MM\dd
	}
	
	
	@Scheduled(cron = "0 * * * * *")// 초 분 시 일 월 주 
	public void checkFiles()throws Exception{
		log.warn("File Check Task run ....................");
		
		log.warn("=======================");
		//db로 부터 전일자 파일 리스트 얻기
		List<BoardAttachVO> fileList = attachMapper.getOldFiles();
		
		//db에서 얻은 file리스트로 파일디렉토리 점검준비
		List<Path> fileListPaths = fileList.stream()
				                               .map(vo->Paths.get("c:\\upload", vo.getUploadPath(), 
				                            		    vo.getUuid()+"_"+vo.getFileName()))
				                               .collect(Collectors.toList());
         
	   //썸네일 처리
		fileList.stream()
		         .filter(vo->vo.isFileType())
		         .map(vo->Paths.get("c:\\upload", vo.getUploadPath(), 
             		    "s_"+vo.getUuid()+"_"+vo.getFileName()))
		         .collect(Collectors.toList());
		
		log.warn("=======================");
		
		fileListPaths.forEach(new Consumer<Path>() {
			@Override
			public void accept(Path p) {
				log.warn(p);
			}
		});
		
		//지난 파일 저장 디렉토리
		File  targetDir= Paths.get("c:\\upload", getFolderYesterDay()).toFile();
		
		//db에서 삭제되었지만 디렉토리에 남아있는 파일 추출
		File[] removeFiles = targetDir.listFiles(file->fileListPaths.contains(file.toPath())==false);
		
		log.warn("------------------------------------------------");
		
		for(File file:removeFiles) {
			log.warn(file.getAbsolutePath());//파일 절대 경로
			log.warn(file.getName());//파일명
			//파일삭제
			file.delete();
		}
	}
}