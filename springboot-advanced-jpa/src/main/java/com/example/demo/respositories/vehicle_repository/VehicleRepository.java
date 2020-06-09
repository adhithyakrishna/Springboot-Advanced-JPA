package com.example.demo.respositories.vehicle_repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.vehicle_entity.Vehicle;

@Repository
@Transactional
public class VehicleRepository {

	@Autowired
	EntityManager em;

	public void insert(Vehicle vehicle) {
		em.persist(vehicle);
	}

	/*
	 * This will not worked when @MappedSuperClass is used on Vehicle because,
	 * employee is no longer an entity and it cannot perform a query on Vehicle
	 */

	public List<Vehicle> retrieveVehicleDetails() {
		return em.createQuery("select v from Vehicle v", Vehicle.class).getResultList();
	}
}
