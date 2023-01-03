package com.gura.boot07.users.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.boot07.users.dto.UsersDto;
import com.gura.boot07.users.service.UsersService;

@Controller
public class UsersController {
	@Autowired
	private UsersService service;

	
	/*
	 * GET 방식 /users/signup_form 요청을 처리할 메소드
	 * - 요청 방식이 다르면 신행되지 않는다.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/users/signup_form")
	public String signupForm() {
		return "users/signup_form";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/users/signup")
	public ModelAndView signup(ModelAndView mView, UsersDto dto) {
		service.addUser(dto);
		mView.setViewName("users/signup");
		return mView;
	}
	//로그인 폼 요청 처리
	@RequestMapping(method = RequestMethod.GET, value = "/users/login_form")
	public String loginForm() {
		return "users/login_form";
	}
	//로그인 요청 처리
	@RequestMapping(method = RequestMethod.POST, value = "/users/login")
	public ModelAndView login(ModelAndView mView, UsersDto dto, String url, HttpSession session) {
		service.loginProcess(dto, session);
		//로그인 후 가야할 목적지 정보를 인코딩하지 않는 것과 인코딩 한 것을 모두 ModelAndView객체에 담고
		String encodedUrl = URLEncoder.encode(url);
		mView.addObject("url", url);
		mView.addObject("encodedUrl", encodedUrl);
		
		mView.setViewName("users/login");
		return mView;
	}
	
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		return "users/logout";
	}
	
	// 개인 정보 보기 요청 처리
	@RequestMapping("/users/info")
	public ModelAndView info(HttpSession session, ModelAndView mView) {

		service.getInfo(session, mView);

		mView.setViewName("users/info");
		return mView;
	}
	//비밀번호 수정 폼 요청 처리
	@RequestMapping("/users/pwd_update_form")
	public String pwdUpdateForm() {
		
		return "users/pwd_update_form";
	}
	//비밀번호 수정 요청 처리
	@RequestMapping("/users/pwd_update")
	public ModelAndView pwdUpdate(UsersDto dto, ModelAndView mView, HttpSession session) {
		//서비스에 필요한 객체의 참조값을 전달해서 비밀번호 수정 로직을 처리한다.
		service.updateUserPwd(session, dto, mView);
		//view page로 forward 이동해서 작업 결과를 응답한다.
		mView.setViewName("users/pwd_update");
		return mView;
	}
	
	
	@RequestMapping("/users/delete")
	public ModelAndView delete(HttpSession session, ModelAndView mView) {
		service.deleteUser(session, mView);
		mView.setViewName("users/delete");
		return mView;
	}
	
	@RequestMapping("/users/update_form")
	public ModelAndView updateform(HttpSession session, ModelAndView mView) {
		service.getInfo(session, mView);
		mView.setViewName("users/update_form");
		return mView;
	}
	
	@RequestMapping(value = "/users/update", method = RequestMethod.POST)
	public ModelAndView update(UsersDto dto, HttpSession session, ModelAndView mView, HttpServletRequest request) {
		//서비스를 이용해서 개인정보를 수정하고
		service.updateUser(dto, session);
		mView.setViewName("redirect:/users/info");
		//개인정보 보기로 리다이렉트 이동시킨다.
		return mView;
	}
	
	//ajax 프로필 사진 업로드 요청 처리
	@ResponseBody
	@RequestMapping(value = "/users/profile_upload", method =RequestMethod.POST)
	public Map<String, Object> profileUpload(MultipartFile image, HttpServletRequest request) {
		
		return service.saveProfileImage(request, image);
	
	}
}
