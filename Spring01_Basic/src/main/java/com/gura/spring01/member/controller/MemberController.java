package com.gura.spring01.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring01.member.dto.MemberDto;

// component scan을 통해서 bean이 될 수 있도록 어노테이션을 붙인다.
@Controller
public class MemberController {
	
	// /member/insertform 요청에 대해서 응답
	@RequestMapping("/member/insertform")
	public String insertform() {
		
		// /WEB-INF/views/member/insertform.jsp로 forward 이동해서 응답
		return "member/insertform";
	}
	
	@ResponseBody // 리턴하는 문자열을 클라이언트에게 직접 출력하기
	@RequestMapping("/member/insert1")
	public String insert1(HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		System.out.println("insert1 : "+num+"|"+name+"|"+addr);
		return "ok1";
	}
	@ResponseBody
	@RequestMapping("/member/insert2")
	public String insert2(int num, String name, String addr) {
		/*
		 * [요청 파라미터 추출하는 방벙2]
		 * 파라미터명과 동일하게 메소드의 매개변수를 선언해놓으면 자동으로 추출해서 넣어준다.
		 * <input name="num"> 이면 int num or String num
		 * */
		System.out.println("insert2 : "+num+"|"+name+"|"+addr);
		return "ok2";
	}
	@ResponseBody
	@RequestMapping("/member/insert3")
	public String insert3(MemberDto dto) {
		System.out.println("insert3 : "+dto.getNum()+"|"+dto.getName()+"|"+dto.getAddr());
		return "ok3";
	}
}

