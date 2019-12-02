package com.java.springboot.task.repository;

import java.util.List;

import com.java.springboot.task.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByName(String name);
    List<Student> findByEmail(String email);
}
