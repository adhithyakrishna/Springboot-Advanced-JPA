package com.example.demo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.FullTimeEmployee;
import com.example.demo.entity.PartTimeEmployee;
import com.example.demo.respository.EmployeeRepository;

@SpringBootApplication
public class AdvancedJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(AdvancedJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		PartTimeEmployee partTime = new PartTimeEmployee("jill", new BigDecimal("50"));
		FullTimeEmployee fullTime = new FullTimeEmployee("jack", new BigDecimal("10000"));
		employeeRepository.insert(partTime);
		employeeRepository.insert(fullTime);

		logger.info("all employees {}", employeeRepository.retrieveEmployee());
	}

}
