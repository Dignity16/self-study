package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// bean id는 thatSillyCoach로 줌
@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach : inside default constructor");
	}
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach : inside of doMyStartupStuff()");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach : inside of doMyCleanupStuff()");
	}
	
	
	/*
	// define a setter method
	@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach : inside doSomeCrazyStuff() method");
		fortuneService = theFortuneService;
	}
	*/

	/*
	// HappyFortuneService의 값을 가져와서 담고
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	//fortuneService안의 getFortune으로 "Today is your lucky day"의 값을 가져올 수 있음
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
