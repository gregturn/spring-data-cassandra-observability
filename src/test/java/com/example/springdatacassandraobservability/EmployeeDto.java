package com.example.springdatacassandraobservability;

import java.util.Objects;

public class EmployeeDto {

	private String firstName;
	private String lastName;
	private String role;

	public EmployeeDto(String firstName, String lastName, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	/**
	 * Virtual field that combines {@link #firstName} and {@link #lastName}
	 */
	public String getFullname() {
		return firstName + " " + lastName;
	}

	/**
	 * Virtual field that extract {@link #firstName} and {@link #lastName}
	 */
	public void setFullname(String fullname) {
		String[] parts = fullname.split(" ");
		this.firstName = parts[0];
		this.lastName = parts[1];
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		EmployeeDto that = (EmployeeDto) o;
		return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName)
				&& Objects.equals(role, that.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, role);
	}

	@Override
	public String toString() {
		return "EmployeeDto{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", role='" + role
				+ '\'' + '}';
	}
}
