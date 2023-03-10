package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory 
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the objects
			/*
			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
																		"Luv 2 code!!!");
			*/
			
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com",
																		"Guitar");
			
			// associate the objects
			// setter 메소드로 InstructorDetail 객체 tempInstructorDetail을 받음
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transactions
			session.beginTransaction();
			
			// save the instructor
			//
			// Note : this will ALSO save the details object
			// because of CascadeType.All
			//
			System.out.println("Saving instructor : " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transactions
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		} finally {
			factory.close();
		}
	
	}

}
