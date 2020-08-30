package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create the objects
			Instructor instructor = new Instructor("Duy", "Pham", "duypham9895@gmail.com");

			InstructorDetail instructorDetail = new InstructorDetail("Duy Pham", "sleep");
			
//			Instructor instructor = new Instructor("Ly", "Nguyen", "ly@gmail.com");
//
//			InstructorDetail instructorDetail = new InstructorDetail("lynguyen", "play");

			// associate the objects
			instructor.setInstructorDetail(instructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			System.out.println("Saving intructor: " + instructor);
			session.save(instructor);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
