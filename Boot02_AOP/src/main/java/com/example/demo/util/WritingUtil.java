package com.example.demo.util;

import org.springframework.stereotype.Component;

//Component scan이 일어났을 때 bean이 될 수 있도록 어노테이션을 붙인다.
@Component
public class WritingUtil {
	//생성자
	public WritingUtil() {
		System.out.println("WU 생성자");
	}
	
	public void write1() {
		System.out.println("SKT T1 FAKER");
	}
	public void write2() {
		System.out.println("SKT FAKER");
	}
	public void write3() {
		System.out.println("T1 FAKER");
	}
}
