package com.jpa.entity;
import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee implements Serializable{
   

	private static final long serialVersionUID = -4003200670938159734L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //generator types
    private Long id;

    private String name;
    private String department;
    
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Long id, String name, String department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + "]";
	}
    
    

}
