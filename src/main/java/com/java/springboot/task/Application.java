package com.java.springboot.task;

import com.java.springboot.task.entity.Faculty;
import com.java.springboot.task.entity.Student;
import com.java.springboot.task.repository.FacultyRepository;
import com.java.springboot.task.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	FacultyRepository facultyRepository;

	@Autowired
    StudentRepository studentRepository;

	List<Faculty> faculties = new ArrayList<>();

	List<Student> students = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		faculties.add(facultyRepository.save(new Faculty("Мехмат")));
		faculties.add(facultyRepository.save(new Faculty("Радиофак")));
		faculties.add(facultyRepository.save(new Faculty("Физфак")));
		faculties.add(facultyRepository.save(new Faculty("Литфак")));

		students.add(studentRepository.save(new Student("Petrov","111", 33, "111", faculties.get(0))));
		students.add(studentRepository.save(new Student("Petrov","111", 33, "111", faculties.get(1))));
		students.add(studentRepository.save(new Student("Petrov","111", 33, "111", faculties.get(2))));
		students.add(studentRepository.save(new Student("Petrov","111", 33, "111", faculties.get(3))));
	}
}