package com.man.Page;

import org.springframework.stereotype.Component;


public class StudentSearchCriteria {
	private String firstname;
	private String lastName;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
