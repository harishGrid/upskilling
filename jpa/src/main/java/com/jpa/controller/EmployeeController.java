package com.jpa.controller;

import org.springframework.web.bind.annotation.*;

import com.jpa.entity.Employee;
import com.jpa.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/sorted")
    public List<Employee> sortedEmployees() {
        return service.getAllEmployeesSortedByName();
    }

    @GetMapping("/example")
    public List<Employee> exampleEmployees(@RequestParam String department) {
        return service.getEmployeesByExample(department);
    }

    @GetMapping("/page")
    public List<Employee> pagedEmployees(@RequestParam int page, @RequestParam int size) {
        return service.getEmployeesByPage(page, size);
    }
}
