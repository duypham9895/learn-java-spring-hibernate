package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> students = session.createQuery("from Student").getResultList();

			// display students
			displayStudents(students);

			// query student: lastName='Pham'
			students = session.createQuery("FROM Student s WHERE s.lastName LIKE 'Pham'").getResultList();
			System.out.println("\n\nStudents who have last name of 'Pham'");

			displayStudents(students);
			
			// query students: lastName='Pham' OR firstName='tobe'
			students = session.createQuery("FROM Student s WHERE s.lastName LIKE 'Pham' OR s.firstName LIKE 'tobe'").getResultList();
			System.out.println("\n\nStudents who have last name of 'Pham' OR first name of 'tobe'");
			
			displayStudents(students);
			
			
			// query students: email = %gmail.com
			students = session.createQuery("FROM Student s WHERE s.email LIKE '%gmail.com'").getResultList();
			System.out.println("\n\nStudents who have email end with 'gmail.com'");
			
			displayStudents(students);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for (Student stu : students) {
			System.out.println(stu);
		}
	}

}
