package com.example.demo.respositories.course_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.course_entity.Course;
import com.example.demo.entities.course_entity.Student;

@RepositoryRestResource(path = "student")
public interface StudentSpringDataRepository extends JpaRepository<Student, Long>{
	
	List<Course> findByNameAndId(String name, Long id);
}
