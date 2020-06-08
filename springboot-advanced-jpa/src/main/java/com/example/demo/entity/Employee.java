package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/*
 * abstract class to make sure nobody can create an instance of that class
 * @inheritence relationship is used to map, inheritence relationship to tables. We are trying to map
 * part time employee and fulltime employee to the same table
 * 
 * @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
 * Puts parttime employee and fulltime employee in the same table
 * one downside to this apporach is that, there would be several nullable fields, which might lead to bad data
 * 
 * @DiscriminatorColumn(name="EmployeeType") - lets you rename how the differentiator column is displayed in the table
 * 
 * 
 * @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) - Table per concrete entity class, i.e subclasses of a concrete
 * class. Employee is an abstract class and object cannot be initialised to it, but fulltimeemployee and parttimeemployee
 * are all concrete classes
 * Though there is induvidual table for each of the subclasses, the way we inser the data and retrieve the data would not
 * vary on the jpa side but the downside is each sublcass will have its own table with a lot of data duplications. Data
 * retrieval uses union
 * 
 * @Inheritance(strategy = InheritanceType.JOINED) differentiating fields are added to a seperate table, the common
 * fields are mapped to a seperate table, join is performed to instantiate the subclasses. Has a really good database
 * design, but in terms of data retrieval it suffers because it has to do outer join on all the subclasses to retrieve
 * data
 * 
 * A @MappedSuperclass cannot be an entity eliminates inheritence relationship in the table
 * Queries has to be made to a seperate table
 */

@MappedSuperclass
//@Entity - removed because of the mapped super class
//@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	protected Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Employee[%s]", name);
	}
}