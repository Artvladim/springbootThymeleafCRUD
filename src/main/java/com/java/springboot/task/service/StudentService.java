package com.java.springboot.task.service;


import com.java.springboot.task.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Optional<Student> findById(Long id);

    List<Student> list();

    List<Student> findByName(String name);

    Student create(Student student);

    Student update(Student student);

    void delete(Long id);
}
