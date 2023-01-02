package com.gura.boot07.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gura.boot07.interceptor.LoginInterceptor;

/*
 * 
 * [Spring MVC 관련 설정]
 * 
 * 1. WebMvcConfigurer 인터페이스를 구현한다.
 * 2. 설정에 필요한 메소드만 오버라이딩한다.
 * 	  주로 Resource Handler 혹은 Interceptor 관련 설정을 여기서한다.
 * 3. 설정에 관련된 클래스에는 @Configuration 어노테이션을 붙여야한다.
 *
 */

@Configuration
//@EnableWebMvc // 스프링이 자동 설정해주는 모든 기능을 사용하기 위해서 붙여주어야 한다.
public class WebConfig implements WebMvcConfigurer {
	/*
	 * servlet-context.xml에서 설정했던
	 * 
	 * webapp/resources/ 안에 있는 내용을 서비스 하기 위한
	 * 
	 * <resoutces mapping="/resources/**" location="/resources/" />
	 * 
	 * 아래 설정을 하면 webapp에 resources 폴더를 만들어놓고 그 안에 들어있는 내용에 대한 요청은
	 * 
	 * spring 프레임워크를 거치지 않고 바로 응답할 수 있다.
	 * 
	 * - SmartEditor2나 프로필 이미지를 저장할 upload 폴더를 만들 예정
	 */
	// 여기서 bean으로 관리도는 MyInterceptor 객체가 필요하다면..

	@Autowired
	LoginInterceptor loginInterceptor;

	// @Autowired 어노테이션에서 주입받은 객체를 이 메소드에서 활용한다
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/users/*", "/gallery/*", "/cafe/*", "/file/*")
		.excludePathPatterns("/users/signup_form","/users/signup", "/users/loginform", "/users/login",
							"/gallery/list", "/gallery/detail",
							"/cafe/list", "/cafe/detail", "/cafe/ajax_comment_list",
							"/file/list", "/file/download"
				);
	}

	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/"); 
	}
	 
				//viewpage와 prefix, suffix 설정
	@Override public void configureViewResolvers(ViewResolverRegistry registry) {
			registry.jsp("/WEB-INF/views/", ".jsp"); 
	}
	
}
