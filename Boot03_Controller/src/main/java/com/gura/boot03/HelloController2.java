package com.gura.boot03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController2 {
	
	//get 방식 /hello2 요청을 해오면 "hello2"라는 문자열이 응답한다(@Responsebody효과)
	@RequestMapping(method = RequestMethod.GET,value="/hello2")
	public String hello2() {
		return "hello2";
	}
	
	//@GetMapping = @RequestMapping(method = RequestMethod.GET,value="/hello2")
	//@PostMapping =  @RequestMapping(method = RequestMethod.POST,value="/hello2")
	@GetMapping
	public String hello3() {
		return "hello3";
	}
}
