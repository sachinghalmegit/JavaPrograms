package com.rest.restfulwebservices.bean;

import java.util.Date;

public class User {
	
	public String username;
	public Integer Id;
	public String FName,LName;
	public Date birthDate;
	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getFName() {
		return FName;
	}

	public void setFName(String fName) {
		FName = fName;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", Id=" + Id + ", FName=" + FName + ", LName=" + LName + ", birthDate="
				+ birthDate + "]";
	}

	public User(String username, Integer id, String fName, String lName, Date birthDate) {
		super();
		this.username = username;
		Id = id;
		FName = fName;
		LName = lName;
		this.birthDate = birthDate;
	}
	
	
	
}
