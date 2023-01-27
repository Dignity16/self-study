package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		// call our new methods to get the literal values
		
		// 왜 Coach 인터페이스가 아닌 CricketCoach 클래스를 사용하는가? - Coach 인터페이스에는 getDailyWorkout, getDailyFortune밖에 없음
		// getTeam, getEmailAddress는 CricektCoach에만(추가 정의) 있으므로 사용하기 위해서는 Coach 인터페이스가 아닌 
		// CricketCoach 클래스를 사용해야함.
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		// close the context
	}

}
