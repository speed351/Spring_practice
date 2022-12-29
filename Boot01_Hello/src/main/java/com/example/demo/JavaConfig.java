package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
 * 어떤 객체를 spring이 생성해서 관리할지 설정(bean 설정)
 */

@Configuration
public class JavaConfig {
	//이 메소드에서 리턴되는 객체를 spring이 관리하는 bean이 되도록 한다.
	//아래의 메소드는 xml문서에서 <bean id="myCar" class="com.example.demo.Car"/>와 같다
	@Bean
	public Car Car() {
		System.out.println("myCar 메소드 호출됨");
		Car c1 = new Car();
		return c1;
	}
	/*
	 * @Bean 어노테이션과 함께 MyCar type을 리턴하는 메소드를 만들어 놓으면
	 * MyCar type 객체가 bean으로 생성되어 spring으로부터 관리된다.
	 * */

}
