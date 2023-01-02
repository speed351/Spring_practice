package com.gura.boot07.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
	//spring framework가 동작하는 중에 NotDeleteException tyep의 예외가 발생하면 호출되는 메소드
	
	@ExceptionHandler(NotDeleteException.class)
	public ModelAndView notDelete(NotDeleteException nde) {//메소드의 인자로 예외 객체가 전달된다.
		ModelAndView mView = new ModelAndView();
		mView.addObject("exception", nde);
		//view page(/WEB-INF/views/error/info.jsp)로 forward 이동해서 예외 정보 응답하기
		mView.setViewName("error/info");
		return mView;
		
	}
	@ExceptionHandler(DeliveryException.class)
	public ModelAndView dataAccess(DeliveryException de) {
		ModelAndView mView = new ModelAndView();
		mView.addObject("exception", de);
		mView.addObject("info", "죄송합니다. 내년부터는 배송가능하도록 노력하겠습니다.");
		mView.setViewName("error/delivery");
		return mView;
		
	}
	
	// DB 관련 작업을 하다가 발생하는ㅁ ㅗ든 예외를 처리하는 컨트롤러
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView dataAccess(DataAccessException dae) {
		ModelAndView mView = new ModelAndView();
		mView.addObject("exception", dae);
		//view page(/WEB-INF/views/error/info.jsp)로 forward 이동해서 예외 정보 응답하기
		mView.setViewName("error/info");
		return mView;
		
	}
}
