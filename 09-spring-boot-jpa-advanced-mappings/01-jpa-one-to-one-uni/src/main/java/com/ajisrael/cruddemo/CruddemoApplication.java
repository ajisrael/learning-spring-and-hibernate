package com.ajisrael.cruddemo;

import com.ajisrael.cruddemo.dao.AppDAO;
import com.ajisrael.cruddemo.entity.Instructor;
import com.ajisrael.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
//			createInstructor(appDAO);

			findInstructor(appDAO);
		};
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
