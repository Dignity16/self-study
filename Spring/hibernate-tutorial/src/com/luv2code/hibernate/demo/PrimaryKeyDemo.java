package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating 3 Student objects...");
			Student tmpStudent1 = new Student("John", "Doe", "john@luv2code.com");
			Student tmpStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
			Student tmpStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

			session.beginTransaction();
			
			System.out.println("Saving the students");
			session.save(tmpStudent1);
			session.save(tmpStudent2);
			session.save(tmpStudent3);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
