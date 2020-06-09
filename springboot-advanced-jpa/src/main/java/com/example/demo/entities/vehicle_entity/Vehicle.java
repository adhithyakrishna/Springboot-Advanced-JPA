package com.example.demo.entities.vehicle_entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
 * If the concern is data integrity use joined
 * JOINED - Each subclass will have its own table and connected together by foreign key
 * 
 * If the concern is performance, use single table strategy
 * SINGLE_TABLE - There would be only one table, but the downside is it will have nullable values
 * 
 * Recommended not to use TABLE_PER_CLASS or MAPPEDSUPERCLASS because that will create a duplicate 
 * columns that doesnt abide by the third normal form
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Vehicle {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	public Vehicle() {

	}

	public Vehicle(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + "]";
	}
}
