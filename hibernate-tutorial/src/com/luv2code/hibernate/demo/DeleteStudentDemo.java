package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 3;

			// start a transaction
			session.beginTransaction();

			// retrieve student based on the id
			System.out.println("\n\nGetting student with id = " + studentId);

			Student student = session.get(Student.class, studentId);
			
			System.out.println(student);

			// delete student
			// System.out.println("Deleting student: " + student);
			// session.delete(student);
			
			// delete student id=2
			System.out.println("Deleting student id = 2");
			session.createQuery("DELETE FROM Student WHERE id=2").executeUpdate();

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
