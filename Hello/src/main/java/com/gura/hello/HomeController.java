package com.gura.hello;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//클라이언트의 요청을 어떻게 처리할지 컨트롤하는 컨트롤러
@Controller
public class HomeController {
	
	
	//어떤 경로에 요청이 왔을떄
	@RequestMapping("/")
	public String home(HttpServletRequest requst ) {
		//어떤 동작을 하고
		
		//공지사항을 읽어오는 비즈니스로직을 수행한다.
		List<String> noticeList = new ArrayList<String>();
		noticeList.add("Spring 프레임워크 시작");
		noticeList.add("ㅇㅉㄱ");
		noticeList.add("ㅈㅉㄱ");
		
		
		//home.jsp 페이지에서 사용할 공지사항을 HttpServletRequest 객체에 담아야 한다.(request scope)
		requst.setAttribute("noticeList", noticeList);
		
		
		//어디로 이동해서 응답할지 정하기(기본이 forward 이동이다)
		return "home";//여기서 "home"이라는 것은 "/WEB-INF/views/"+"home"+".jsp"의 home이다.
	}
	
	@RequestMapping("/send")
	public String send(HttpServletRequest request) {
		String msg = request.getParameter("msg");
		System.out.println("클라이언트가 전송한 문자열 : " + msg);
		
		//view page(jsp)로 forward 이동해서 응답하기
		return "send";
	}
	
	@RequestMapping("/fortune")
	public String fortune(HttpServletRequest request ) {
		//오늘의 운세(data) 모델(model)을 request scope에 담고
		request.setAttribute("fortuneToday", "집에 가라");
		//view page(jsp)로 forward 이동해서 응답하기
		return "fortune";
	}
}
