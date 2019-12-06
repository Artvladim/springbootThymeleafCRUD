package com.java.springboot.task;

import com.java.springboot.task.entity.Faculty;
import com.java.springboot.task.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	FacultyRepository facultyRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    
		facultyRepository.save(new Faculty("Faculty 1"));
	}
}