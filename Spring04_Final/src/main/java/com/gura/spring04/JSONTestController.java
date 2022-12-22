package com.gura.spring04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring04.users.dto.UsersDto;

/*
 * 1. jackson-databind 라이브러리가 dependency에 명시가 되어 있고
 * 2. servlet-context.xml에 <annotation-driven/>이 명시되어 있고
 * 3. 컨트롤러 메소드에 @ResponseBody 어노테이션이 붙어있으면
 * Map or dto or List 객체에 담긴 내용이 json 문자열로 변환되어 응답한다.
 */
@Controller
public class JSONTestController {
	
	@ResponseBody
	@RequestMapping("/get_msg")
	public String getMsg() {
		return "hello";
	}
	
	@ResponseBody
	@RequestMapping("/get_person")
	public Map<String, Object> getPerson() {
		Map<String, Object> map = new HashMap<>();
		map.put("num",1);
		map.put("name","faker");
		map.put("isMan",true);
		return map;
	}
	@ResponseBody
	@RequestMapping("/get_user")
	public UsersDto getUser() {
		UsersDto dto = new UsersDto();
		dto.setId("faker");
		dto.setPwd("1234");
		dto.setEmail("demonking");
		
		return dto;
	}
	
	@ResponseBody
	@RequestMapping("/get_friends")
	public List<String> getFriends() {
		List<String> friends = new ArrayList<>();
		friends.add("faker");
		friends.add("deft");
		friends.add("pray");
		return friends;
	}
	@ResponseBody
	@RequestMapping("/get_users")
	public List<UsersDto> getUsers() {
		List<UsersDto> list = new ArrayList<>();
		UsersDto dto = new UsersDto();
		dto.setId("faker");
		dto.setPwd("1234");
		dto.setEmail("t1");
		
		UsersDto dto2 = new UsersDto();
		dto.setId("deft");
		dto.setPwd("1234");
		dto.setEmail("dwg");
		
		list.add(dto);
		list.add(dto2);
		
		return list;
	}
}
