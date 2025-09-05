package com.jpa.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entity.Employee;
import com.jpa.entity.Task;
import com.jpa.repository.EmployeeRepository;
import com.jpa.repository.TaskRepository;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    
    private final TaskRepository taskRepository;

    public EmployeeService(EmployeeRepository employeeRepository,TaskRepository taskRepository) {
        this.employeeRepository = employeeRepository;
        this.taskRepository=taskRepository;
    }

    // Sorting
    public List<Employee> getAllEmployeesSortedByName() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    // Query by Example
    public List<Employee> getEmployeesByExample(String department) {
        Employee probe = new Employee();
        probe.setDepartment(department);
        Example<Employee> example = Example.of(probe);
        return employeeRepository.findAll(example);
    }

    // Pagination
    public List<Employee> getEmployeesByPage(int page, int size) {
        Page<Employee> employeePage = employeeRepository.findAll(PageRequest.of(page, size, Sort.by("name")));
        return employeePage.getContent();
    }

    // Transaction
    @Transactional
    public void createEmployeeWithTask(Employee employee, Task task) {
        employeeRepository.save(employee);
        task.setEmployee(employee);
        taskRepository.save(task);
    }
}
