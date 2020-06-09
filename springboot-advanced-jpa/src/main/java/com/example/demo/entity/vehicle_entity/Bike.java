package com.example.demo.entity.vehicle_entity;

import javax.persistence.Entity;

@Entity
public class Bike extends Vehicle{
	
	private int smallInsuranceAmount;

	protected Bike() {

	}

	public Bike(int smallInsuranceAmount, String name) {
		super(name);
		this.smallInsuranceAmount = smallInsuranceAmount;
	}
}
