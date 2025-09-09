package com.query.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserQuery {
    @Id
    private String id;
    private String name;
    private String email;
	public UserQuery() {
		super();
	}
	public UserQuery(String id, String name, String email) {
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
		return "UserQuery [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
    
}