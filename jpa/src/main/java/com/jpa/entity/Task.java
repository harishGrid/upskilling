package com.jpa.entity;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(Long id, String title, Employee employee) {
		super();
		this.id = id;
		this.title = title;
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", employee=" + employee + "]";
	}
}
