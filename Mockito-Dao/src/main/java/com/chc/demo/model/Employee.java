package com.chc.demo.model;

public class Employee {
	private long id;
	private String name;
	private String sal;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public Employee(long id, String name, String sal) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employer [id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}

}
