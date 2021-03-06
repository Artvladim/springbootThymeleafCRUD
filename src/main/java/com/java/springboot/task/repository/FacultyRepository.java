package com.java.springboot.task.repository;

import com.java.springboot.task.entity.Faculty;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends PagingAndSortingRepository<Faculty, Long> {
    List<Faculty> findByName(String name);
}
