package com.example.demo.respositories.course_repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.course_entity.Course;
import com.example.demo.entity.course_entity.Passport;
import com.example.demo.entity.course_entity.Student;


@Repository
@Transactional
public class StudentRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public Student save(Student student) {

		if (student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}

		return student;
	}

	public void deleteById(Long id) {
		Student student = findById(id);
		em.remove(student);
	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		/*
		 * It is important to note that we persist the passport first before we persist
		 * student because, student owns passport and student has the repository called
		 * passport id
		 */

		em.persist(passport);

		Student student = new Student("Mike");

		student.setPassport(passport);
		em.persist(student);
	}

	public void someOperationToUnderstandPersistenceContext() {
	}
	
	public void insertStudentAndCourse() {
		Student student = new Student("krishna");
		Course course = new Course("welcome to this world");
		em.persist(student);
		em.persist(course);
		
		student.addCourses(course);
//		course.addStudents(student);
		
		em.persist(student);
	}

}
