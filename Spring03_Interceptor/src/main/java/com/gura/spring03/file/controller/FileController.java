package com.gura.spring03.file.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.gura.spring03.file.dto.FileDto;

/*
 * [spring mvc 파일 업로드 처리] 
 * 1. pom.xml에 아래의 defendency가 있어야 한다.
 * 		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.4</version>
		</dependency>
		<dependency>
			<groupId>commons-fileupload</groupId>
			<artifactId>commons-fileupload</artifactId>
			<version>1.3.1</version>
		</dependency>
 * 2. servlet-context.xml에 MultipartResolver bean 설정이 있어야 한다.
 * 3. MultipartFile 객체를 컨트롤러에서 받아서 사용하면 된다.
 * 	 <!-- Multipart 폼 전송 처리를 위한 bean 설정 -->
	<beans:bean id="multipartResolver"
	   class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	   <beans:property name="maxUploadSize" value="102400000"/>
	</beans:bean>   
 * 
 */


@Controller
public class FileController {

	@RequestMapping("/file/insertform")
	public String insertform() {

		return "file/insertform";
	}
	
	//FileDto에는 폼 전송된 title, myFile 정보가 들어있다.
	@RequestMapping("/file/upload2")
	public String upload2(FileDto dto, HttpServletRequest request) {
		//FileDto로부터 업로드된 파일의 정보를 담고 있는 MultipartFile 객체의 참조값 얻어내기
		MultipartFile myFile = dto.getMyFile();
		// 원본 파일명
		String orgFileName = myFile.getOriginalFilename();
		// 파일의 크기
		long fileSize = myFile.getSize();

		// webapp/upload 폴더 까지의 실제 경로(서버의 파일시스템 상에서의 경로)
		String realPath = request.getServletContext().getRealPath("/upload");
		// 저장할 파일의 상세 경로
		String filePath = realPath + File.separator;
		// 디렉토리를 만들 파일 객체 생성
		File upload = new File(filePath);
		if (!upload.exists()) {// 만일 디렉토리가 존재하지 않으면
			upload.mkdir(); // 만들어 준다.
		}
		// 저장할 파일 명을 구성한다.
		String saveFileName = System.currentTimeMillis() + orgFileName;
		try {
			//3. 임시 폴더에 저장된 업로드된 파일을 원하는곳에 원하는 이름으로 이동시키기.
			myFile.transferTo(new File(filePath + saveFileName));
			System.out.println(filePath + saveFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "file/upload2";
	}
	

	@RequestMapping("/file/upload")
	public String upload(String title, MultipartFile myFile, HttpServletRequest request) {
		// 원본 파일명
		String orgFileName = myFile.getOriginalFilename();
		// 파일의 크기
		long fileSize = myFile.getSize();

		// webapp/upload 폴더 까지의 실제 경로(서버의 파일시스템 상에서의 경로)
		String realPath = request.getServletContext().getRealPath("/upload");
		// 저장할 파일의 상세 경로
		String filePath = realPath + File.separator;
		// 디렉토리를 만들 파일 객체 생성
		File upload = new File(filePath);
		if (!upload.exists()) {// 만일 디렉토리가 존재하지 않으면
			upload.mkdir(); // 만들어 준다.
		}
		// 저장할 파일 명을 구성한다.
		String saveFileName = System.currentTimeMillis() + orgFileName;
		try {
			//3. 임시 폴더에 저장된 업로드된 파일을 원하는곳에 원하는 이름으로 이동시키기.
			myFile.transferTo(new File(filePath + saveFileName));
			System.out.println(filePath + saveFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "file/upload";
	}
}
