package com.UserBusiness.Entities;

import jakarta.persistence.Entity;


@Entity
public class UserProfile extends Profile {
    
    private String username;

	public UserProfile(String firstName, String lastName, String type, String username) {
		super(firstName, lastName, type);
		this.username = username;
		// TODO Auto-generated constructor stub
	}
	
	public UserProfile() {
		
	}

	public UserProfile(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
    
    
    

	}
