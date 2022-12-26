package com.example.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WritingAspect {
	
	@Before("execution(void write*())")
	public void prepare() {
		System.out.println("----START----");
		System.out.println("LCK ! ");
	}
	@After("execution(void write*())")
	public void end() {
		System.out.println("Fighting! ");
		System.out.println("-----END-----");
		System.out.println();
	}
}
