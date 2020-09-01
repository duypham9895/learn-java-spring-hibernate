package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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

			// create a course
			Course course = new Course("Python");

			// save the course
			System.out.println("Saving the course...");
			session.save(course);
			System.out.println("Saved the course: " + course);

			// create the students
			Student student1 = new Student("Dao", "Nguyen", "annguyen@gmail.com");
			Student student2 = new Student("Hung", "Pham", "luutran@gmail.com");

			// add students to the course
//			course.addStudent(student1);
//			course.addStudent(student2);
			
			//add course to the students
			student1.addCourse(course);
			student2.addCourse(course);

			// save the students
			System.out.println("Saving the students...");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved the students: " + course.getStudents());

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
