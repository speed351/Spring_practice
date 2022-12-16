package com.gura.spring02.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.member.dto.MemberDto;
import com.gura.spring02.member.service.MemberService;

@Controller
public class MemberController {
	
	//필요한 핵심 의존객체를 주입받는다 @Autowired를 통해
	//controller는 dao가 아닌 service에 의존하도록 만든다
	@Autowired
	private MemberService service;
	

	
	@RequestMapping("/member/update")
	public String update(MemberDto dto){
		//서비스를 이용해서 회원 한명의 정보를 수정
		service.updateMember(dto);
		return "member/update";
	}
	
	@RequestMapping("/member/updateform")
	public ModelAndView updateform(int num, ModelAndView mView) {
		//서비스를 이용해서 회원 한명의 정보를 ModelAndView 객체에 담는다
		service.getMember(num, mView);
		//view page의 정보도 담아서
		mView.setViewName("member/updateform");
		return mView;
	}
	
	@RequestMapping("/member/delete")
	public String delete(int num) {
		service.deleteMember(num);
		return "redirect:/member/list";
	}
	
	
	@RequestMapping("/member/insert")
	public String insert(MemberDto dto) {//폼전송되는 name,addr이 자동으로 추출되어서 MemberDto에 담겨서 전달된다.
		service.addMember(dto);
		return "member/insert";
	}
	
	@RequestMapping("/member/insertform")
	public String insertform() {
		// /WEB-INF/views/member/insertform.jsp로 forward 이동해서 응답
		return "member/insertform";
	}
	
	@RequestMapping("/member/list")
	public ModelAndView getList(ModelAndView mView) {
		//service를 통해 회원목록을 ModelAndView에 받아온다.
		service.getListMember(mView);
		
		// view page 정보도 담아서 
		mView.setViewName("member/list");
		
		//리턴해준다.
		return mView;
	}
}
