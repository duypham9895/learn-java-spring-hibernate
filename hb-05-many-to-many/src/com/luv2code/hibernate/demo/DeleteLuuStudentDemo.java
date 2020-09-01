package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteLuuStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(Review.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the student Luu from the
			int studentId = 2;
			Student student = session.get(Student.class, studentId);

			System.out.println("Loaded student: " + student);
			System.out.println("Course of Student: " + student.getCourses());
			
			// delete the student
			System.out.println("Deleting the student ...");
			session.delete(student);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {

			// add clean up code
			session.close();

			factory.close();
		}

	}

}
