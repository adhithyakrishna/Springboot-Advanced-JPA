package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entities.vehicle_entity.Bike;
import com.example.demo.entities.vehicle_entity.Vehicle;
import com.example.demo.respositories.vehicle_repository.VehicleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdvancedJpaApplication.class)
public class InheritanceStrategyJoinTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	VehicleRepository vehicleRepository;

	@Test
	public void insertVehicle() {
		Vehicle vehicle = new Bike(200, "Pular");
		vehicleRepository.insert(vehicle);
	}
	
	
	@Test
	public void retrieveVehicleDetails()
	{
		List<Vehicle> vehicleInfo = vehicleRepository.retrieveVehicleDetails();
		logger.info("{}", vehicleInfo);
		logger.info("Fetching vehicle info is done");
	}
}


