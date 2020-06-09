package com.example.demo.respositories.employee_repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.employee_entity.Employee;
import com.example.demo.entities.employee_entity.FullTimeEmployee;
import com.example.demo.entities.employee_entity.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public void insert(Employee employee) {
		em.persist(employee);
	}

	/*
	 * Since MappedSuperClass is used, no table would be created for Employee superclass,
	 * there would be induvidual tables created for parttimeemployee and fulltimeemployee
	 * hence they can be directly accessued using the queries like below
	 */

	public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}

	public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
		return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}

}
