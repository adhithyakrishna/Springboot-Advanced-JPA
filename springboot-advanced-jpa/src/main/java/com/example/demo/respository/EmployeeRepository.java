package com.example.demo.respository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;
import com.example.demo.entity.FullTimeEmployee;
import com.example.demo.entity.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public void insert(Employee employee) {
		em.persist(employee);
	}
	
	public List<Employee> retrieveEmployee(){
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}
	
	

	/* public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
		
	}

	public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {

	} */

}