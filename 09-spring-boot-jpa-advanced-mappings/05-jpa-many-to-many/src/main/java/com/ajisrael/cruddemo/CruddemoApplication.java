package com.ajisrael.cruddemo;

import com.ajisrael.cruddemo.dao.AppDAO;
import com.ajisrael.cruddemo.entity.Course;
import com.ajisrael.cruddemo.entity.Instructor;
import com.ajisrael.cruddemo.entity.InstructorDetail;
import com.ajisrael.cruddemo.entity.Review;
import com.ajisrael.cruddemo.entity.Student;
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

//			createCourseAndStudents(appDAO);

//			retrieveCourseAndStudents(appDAO);

//			retrieveStudentAndCourses(appDAO);

//			addMoreCoursesForStudent(appDAO);

//			deleteCourse(appDAO);

			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting student with id: " + theId);
		appDAO.deleteStudentById(theId);
		System.out.println("Done!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int id = 2;

		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		Course course1 = new Course("Rubik's Cube - How to Speed Cube");
		Course course2 = new Course("Atari 2600 - Game Development");

		student.add(course1);
		student.add(course2);

		System.out.println("Updating student: " + student);
		System.out.println("associated courses: " + student.getCourses());

		appDAO.update(student);

		System.out.println("Done");
	}

	private void retrieveStudentAndCourses(AppDAO appDAO) {
		int id = 2;

		System.out.println("Finding student with id: " + id);
		Student student = appDAO.findStudentAndCoursesByStudentId(id);
		System.out.println("Student: " + student);

		System.out.println("the associated courses: " + student.getCourses());

		System.out.println("Done");

	}

	private void retrieveCourseAndStudents(AppDAO appDAO) {
		int id = 10;

		System.out.println("Finding course with id: " + id);
		Course course = appDAO.findCourseAndStudentsByCourseId(id);
		System.out.println("Course: " + course);

		System.out.println("the associated students: " + course.getStudents());

		System.out.println("Done");

	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course course = new Course("Pacman - How To Score One Million Points");

		Student student1 = new Student("John", "Doe", "john@luv2code.com");
		Student student2 = new Student("Mary", "Public", "john@luv2code.com");

		course.add(student1);
		course.add(student2);

		System.out.println("Saving course: " + course);
		System.out.println("associated students: " + course.getStudents());

		appDAO.save(course);

		System.out.println("Done");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;

		System.out.println("Deleting course id: " + id);

		// Will delete reviews because of CascadeType.ALL
		appDAO.deleteCourseById(id);

		System.out.println("Done");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int id = 10;

		System.out.println("Finding course with id: " + id);
		Course course = appDAO.findCourseAndReviewsByCourseId(id);
		System.out.println("Course: " + course);

		System.out.println("the associated reviews: " + course.getReviews());

		System.out.println("Done");

	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("Pacman - How To Score One Million Points");

		course.add(new Review("Great course ... loved it!"));
		course.add(new Review("Cool course, job well done."));
		course.add(new Review("Eh could have been better."));

		System.out.println("Saving course: " + course);
		System.out.println("The reviews: " + course.getReviews());

		appDAO.save(course);
	}


	private void createInstructorWithCoursesAndReviews(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Susan", "Public", "susan@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("The Pinball Masterclass");

		Review review1 = new Review("Great course!");
		Review review2 = new Review("Eh could have been better.");
		Review review3 = new Review("Meh, not the best");

		course1.add(review1);
		course1.add(review2);
		course2.add(review3);

		tempInstructor.add(course1);
		tempInstructor.add(course2);

		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());

		appDAO.save(tempInstructor);

		System.out.println("Done!!!");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;

		System.out.println("Finding course id: " + id);
		Course course = appDAO.findCourseById(id);

		System.out.println("Updating course id: " + id);
		course.setTitle("Enjoy the Simple Things");

		appDAO.update(course);

		System.out.println("Done");
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

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course with id: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
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
