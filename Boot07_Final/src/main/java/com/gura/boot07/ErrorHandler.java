package com.gura.boot07;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorHandler implements ErrorController{
	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		int code = (int)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(code == HttpStatus.NOT_FOUND.value() ) { // 404 error
			return "error/404";
		}else if (code == HttpStatus.INTERNAL_SERVER_ERROR.value()) { // 500 error
			return "error/500";
		}else {
			return "error/info";
		}
	}
}
