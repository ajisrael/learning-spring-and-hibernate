package com.ajisrael.cruddemo;

import com.ajisrael.cruddemo.dao.AppDAO;
import com.ajisrael.cruddemo.entity.Course;
import com.ajisrael.cruddemo.entity.Instructor;
import com.ajisrael.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
//			createInstructor(appDAO);

//			findInstructor(appDAO);

//			deleteInstructor(appDAO);

//			findInstructorDetail(appDAO);

//			deleteInstructorDetail(appDAO);

//			createInstructorWithCourses(appDAO);

//			findInstructorWithCoursesWithJoinFetch(appDAO);

//			findCoursesForInstructor(appDAO);

			updateInstructor(appDAO);
		};
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Updating instructor id: " + id);
		instructor.setLastName("TESTER");

		appDAO.update(instructor);

		System.out.println("Done");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Finding instructor id: " + theId);
		Instructor instructor = appDAO.findInstructorById(theId);
		System.out.println("instructor: " + instructor);

		System.out.println("Finding courses for instructor");
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		instructor.setCourses(courses);
		System.out.println("the associated courses: " + instructor.getCourses());

		System.out.println("Done");
	}

	private void findInstructorWithCoursesWithJoinFetch(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("instructor: " + instructor);
		System.out.println("the associated courses: " + instructor.getCourses());

		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Susan", "Public", "susan@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		tempInstructor.add(course1);

		Course course2 = new Course("The Pinball Masterclass");
		tempInstructor.add(course2);

		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());

		appDAO.save(tempInstructor);

		System.out.println("Done!!!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 4;

		System.out.println("Deleting instructor detail with id: " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 1;

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructorDetail: " + instructorDetail);

		System.out.println("the associated instructor: " + instructorDetail.getInstructor());

		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting instructor with id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 4;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		/*
		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");
		 */

		Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Guitar");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);

		// save the instructor
		//
		// NOTE: this wil ALSO save the details object
		// because of CascadeType.ALL
		//
		appDAO.save(tempInstructor);

		System.out.println("Done!!!");
	}
}
