package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateEmployeeDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			// start a transaction
			session.beginTransaction();

			// retrieve student based on the id
			System.out.println("\n\nGetting student with id = " + studentId);

			Student student = session.get(Student.class, studentId);

			System.out.println(student);

			System.out.println("Updating student...");

			student.setFirstName("Duy");

			// commit transaction
			session.getTransaction().commit();

			// --------------------------------------------------//

			// update email for student
			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Update email for all students");

			session.createQuery("UPDATE Student SET email='foo@yahoo.com'").executeUpdate();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

			System.out.println(student);

		} finally {
			factory.close();
		}

	}

}
