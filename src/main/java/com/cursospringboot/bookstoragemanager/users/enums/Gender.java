package com.cursospringboot.bookstoragemanager.users.enums;

public enum Gender {

	MALE("Male"),
	FEMALE("Female");
	
	private Gender(String description) {
		this.description = description;
	}
	
	private String description;

	public String getDescription() {
		return description;
	}
	
	
}
