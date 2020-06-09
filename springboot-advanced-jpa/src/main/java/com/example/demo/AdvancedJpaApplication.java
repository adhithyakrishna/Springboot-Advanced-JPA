package com.example.demo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.employee_entity.FullTimeEmployee;
import com.example.demo.entities.employee_entity.PartTimeEmployee;
import com.example.demo.entities.vehicle_entity.Bike;
import com.example.demo.entities.vehicle_entity.Car;
import com.example.demo.entities.vehicle_entity.Vehicle;
import com.example.demo.respositories.employee_repository.EmployeeRepository;
import com.example.demo.respositories.vehicle_repository.VehicleRepository;

@SpringBootApplication
public class AdvancedJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	public static void main(String[] args) {
		SpringApplication.run(AdvancedJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		vehicleRepository.insert(new Bike(150, "Avengers"));
		vehicleRepository.insert(new Car(5000, "Lamborghini"));

		employeeRepository.insert(new FullTimeEmployee("John", new BigDecimal(123)));
		employeeRepository.insert(new PartTimeEmployee("Kumar", new BigDecimal(20)));
	}

}
