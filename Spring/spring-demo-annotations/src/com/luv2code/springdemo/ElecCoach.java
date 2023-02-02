package com.luv2code.springdemo;


public class ElecCoach implements Coach {
	
	private FortuneService fortuneService;
	
	
	public ElecCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "기타 연습을 매일 하십시오.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
