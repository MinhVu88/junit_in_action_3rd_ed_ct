package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.hamcrest;

public class Customer {
	private String firstName;
	private String lastName;

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
