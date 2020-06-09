package com.example.demo;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.employee_entity.FullTimeEmployee;
import com.example.demo.respositories.employee_repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdvancedJpaApplication.class)
public class InheritenceStrategyMappedSuperQueryTest {

private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Test
	public void insertEmployee() {
		employeeRepository.insert(new FullTimeEmployee("Abraham", new BigDecimal(12)));
	}
	
	@Test
	public void retrieveEmployee() {
		List<FullTimeEmployee> fullEmployee = employeeRepository.retrieveAllFullTimeEmployees();
		logger.info("{}", fullEmployee);
		logger.info("fetchin employees done");
	}
	
}
