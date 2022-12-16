package com.gura.spring01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	
	@Autowired // Spring Bean Container에 RemoconService type 객체가 있으면 자동으로 주입된다(DI)
	private RemoconServiceImpl service;
	
	@ResponseBody
	@RequestMapping("/di/up")
	public String diUp() {
		/*
		 * 채널을 올리는 로직을 수행할 때 필요한 객체는? 
		 * 
		 * Remocon 
		 * */
		service.up();
		
		return "ok up!";
	}
	@ResponseBody
	@RequestMapping("/di/down")
	public String diDown() {
		
		
		service.down();
		return "ok down";
	}
	
	@RequestMapping("/di/test")
	public String diTest() {
		return "di/test";
	}
	
	@RequestMapping("/move/test")
	public String test() {
		
		
		// /WEB-INF/views/move/test.jsp 페이지로 forward 이동
		return "move/test";
	}
	@RequestMapping("/move/update")
	public String update() {
		
		System.out.println("뭔가 수정되었습니다.");
		//클라이언트에게 새로운 경로로 요청을 다시하라고 강요하기(redirect 이동)
		
		return "redirect:/move/test";
	}
	
	@RequestMapping("/move/fortune")
	public ModelAndView fortune() {
		//model과 view page의 위치를 동시에 담을 수 있는 ModelAndView 객체 생성
		ModelAndView mView = new ModelAndView();
		
		//view page에 전달한 모델(data)라고 가정
		String fortuneToday = "집에 가자";
		
		mView.addObject("fortuneToday",fortuneToday);
		
		//view page의 위치를 담는다
		mView.setViewName("move/fortune");
		
		return mView;
	}
	
	
	//ModelAndView 객체가 필요하다면 직접 생성하지 않고 메소드의 매개변수로 선언하면 자동으로 전달된다.
	@RequestMapping("/move/fortune2")
	public ModelAndView fortune2(ModelAndView mView) {
		//model과 view page의 위치를 동시에 담을 수 있는 ModelAndView 객체 생성
		
		
		//view page에 전달한 모델(data)라고 가정
		String fortuneToday = "집에 가자니깐";
		
		mView.addObject("fortuneToday",fortuneToday);
		
		//view page의 위치를 담는다
		mView.setViewName("move/fortune");
		
		return mView;
	}
	
	@RequestMapping("/move/fortune3")
	public ModelAndView fortune3() {
		//model과 view page의 위치를 동시에 담을 수 있는 ModelAndView 객체 생성
		ModelAndView mView = new ModelAndView("move/fortune");
		
		//view page에 전달한 모델(data)라고 가정
		String fortuneToday = "집에 가자고 했쟈냐";
		mView.addObject("fortuneToday",fortuneToday);
		
		return mView;
	}
	
	
}
