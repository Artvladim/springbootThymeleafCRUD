package com.java.springboot.task.service;

import com.java.springboot.task.entity.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultyService {
    Optional<Faculty> findById(Long id);

    List<Faculty> list();

    List<Faculty> findByName(String name);

    Faculty create(Faculty faculty);

    Faculty update(Faculty faculty);

    void delete(Long id);
}
