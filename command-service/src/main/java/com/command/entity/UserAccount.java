package com.command.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserAccount {
    @Id
    private String id;
    private String name;
    private String email;
	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserAccount(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
    
}