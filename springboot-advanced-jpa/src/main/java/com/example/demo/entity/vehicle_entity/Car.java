package com.example.demo.entity.vehicle_entity;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {

	private int bigInsuranceAmount;

	protected Car() {

	}

	public Car(int bigInsuranceAmount, String name) {
		super(name);
		this.bigInsuranceAmount = bigInsuranceAmount;
	}

}
