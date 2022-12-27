package com.gura.spring04.gallery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.file.dto.FileDto;
import com.gura.spring04.gallery.dto.GalleryDto;
import com.gura.spring04.gallery.service.GalleryService;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService service;
	
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
