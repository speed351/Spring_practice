package com.gura.boot07.gallery.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.boot07.gallery.dto.GalleryDto;
import com.gura.boot07.gallery.service.GalleryService;
import com.gura.boot07.file.dto.FileDto;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService service;
	
	@Value("${file.location}")
	private String fileLocation;
	
	//프로필 이미지 요청에 대한 응답을 할 메소드를 따로 만들어야한다.
	//이미지 데이터가 응답되어야 한다.
	//웹브라우저에게 이미지 데이터를 응답한다고 알려줘야 한다.
	//응답할 이미지의 이름은 그때 그때 다르다. 경로변수(path variable)를 사용해서 처리해준다
	// 이컨트롤러 메소드에서 응답한 byte[] 배열을 클라이언트에게 응답하는 방법
	// 1. @ResponseBody
	// 2. byte[] 배열 리턴
	// 응답된 byte[]배열에 있는 데이터를 이미지 클라이언트 웹브라우저가 인식하게 하는 방법
	// produces=MediaType.IMAGE_JPEG_VALUE
	@GetMapping(
		value="/gallery/images/{imageName}",
		produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE}
	)
	@ResponseBody
	public byte[] galleryImage(@PathVariable("imageName") String imageName) throws IOException {
		String absoulutePath= fileLocation+File.separator+imageName;
		//파일에서 읽어들일 InputStream
		InputStream is = new FileInputStream(absoulutePath);

		return IOUtils.toByteArray(is);
	}
	
	
	@RequestMapping("/gallery/list")
	public String list(HttpServletRequest request) {
		service.getList(request);
		
		return "gallery/list";
	}
	
	@RequestMapping("/gallery/upload_form")
	public String insert_Form() {
		
		return "gallery/upload_form";
	}
	
	@RequestMapping("/gallery/upload")
	public ModelAndView upload(GalleryDto dto, ModelAndView mView, HttpServletRequest request) {
		service.saveContent(dto, mView, request);
		mView.setViewName("gallery/upload");
		
		return mView;
	}
	
	@RequestMapping("/gallery/detail")
	public String detail(HttpServletRequest request) {
		service.getDetail(request);
		return "/gallery/detail";
	}
	
	@RequestMapping("/gallery/delete")
	public String delete(int num, HttpServletRequest request) {
		service.deleteContent(num, request);
		return "redirect:/gallery/list";
	}
	@RequestMapping("/gallery/update_form")
	public String updateForm(HttpServletRequest request) {
		service.getData(request);
		return "gallery/update_form";
	}
	@RequestMapping("/gallery/update")
	public String update(GalleryDto dto) {
		service.updateContent(dto);
		return "gallery/update";
	}
}
