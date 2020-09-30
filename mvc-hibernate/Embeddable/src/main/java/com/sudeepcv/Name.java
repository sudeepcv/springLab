package com.sudeepcv;

import javax.persistence.Embeddable;

@Embeddable
public class Name {
    private String firstName;
    private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}