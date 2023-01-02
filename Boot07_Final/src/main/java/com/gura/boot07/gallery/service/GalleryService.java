package com.gura.boot07.gallery.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.boot07.gallery.dto.GalleryDto;

public interface GalleryService {
	public void getList(HttpServletRequest request);
	public void getDetail(HttpServletRequest request);
	public void saveContent(GalleryDto dto, ModelAndView mView, HttpServletRequest request);
	public void updateContent(GalleryDto dto);
	public void deleteContent(int num, HttpServletRequest request);
	public void getData(HttpServletRequest request); // 글 수정하기 위해 정보 불러오는 기능
}
