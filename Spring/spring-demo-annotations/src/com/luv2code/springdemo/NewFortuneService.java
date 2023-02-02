package com.luv2code.springdemo;

public class NewFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "당신은 운이 좋습니다.";
	}
	
}
