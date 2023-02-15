package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

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
			
			
			// start a transactions
			session.beginTransaction();

			// get instructor by primary key / id
			int id = 1;
			
			// 만약 해당하는 값이 없으면 null을 반환한다.
			Instructor temp = session.get(Instructor.class, id);
			
			// delete the instructors
			if(temp != null) {
				System.out.println("Deleting : " + temp);
				
				session.delete(temp);
			}
			
			// commit transactions
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		} finally {
			factory.close();
		}
	
	}

}
