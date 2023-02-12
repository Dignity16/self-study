package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class testDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			// List<Student> studentList = session.createQuery("from Student").list();
			
			// for(Student s : studentList) {
			//	System.out.println("�л� ���� : " + s);
			// }
			
			
			// Student theStudent = session.get(Student.class, 3);
			// System.out.println("3�� �л��� ���� : " + theStudent);
			
			Student newStudent = new Student("Jake" ,"Kim", "jaewon.jk@gmail.com");
			session.save(newStudent);
			
			
			Student selectStudent = session.get(Student.class, newStudent.getId());
			System.out.println("������ �л� ���� ���  :" + selectStudent);
			
			
			// session.createQuery("delete from Student where id=5").executeUpdate();
			
			// session.createQuery("update Student set firstName='Jake' where id=4").executeUpdate();
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	
	}

}
