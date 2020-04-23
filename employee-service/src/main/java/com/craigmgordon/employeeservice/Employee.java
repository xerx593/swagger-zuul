package com.craigmgordon.employeeservice;

public class Employee {
	
	public Employee(String name, String staffNumber) {
		super();
		this.name = name;
		this.staffNumber = staffNumber;
	}

	private String name;
	private String staffNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

}
