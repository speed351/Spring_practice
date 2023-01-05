package com.gura.boot07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

/*
 * 
 * 이 프로젝트로 xxx.war 파일을 만들어서 외부 tomcat으로 실행하려면 
 * SpringBootServletInitializer을 상속받아서 설정해야 한다.
 *
 */
@SpringBootApplication
@PropertySource("classpath:custom.properties")
public class Boot07FinalApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Boot07FinalApplication.class, args);
		
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(Boot07FinalApplication.class);
	}

}
