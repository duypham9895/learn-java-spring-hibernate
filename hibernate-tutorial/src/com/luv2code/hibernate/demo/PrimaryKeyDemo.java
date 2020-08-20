package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// create 3 student objects
			System.out.println("Creating 3 student objects...");
			Student student1 = new Student("tobe", "wat", "tobe@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			System.out.println(student1);
			session.save(student1);

			// commit transaction
			session.getTransaction().commit();

			// find out the student's id: primary key

			System.out.println("Saved student. Generate ID: " + student1.getId());

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			Student stuFound = session.find(Student.class, student1.getId());
			System.out.println(stuFound.toString());
			
			session.getTransaction().commit();

			// commit the transaction

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
