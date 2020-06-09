package com.example.demo.entity.employee_entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {

	private BigDecimal hourlyWage;
	
	protected PartTimeEmployee() {
	
	}

	public PartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}


}