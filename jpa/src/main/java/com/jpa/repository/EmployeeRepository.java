package com.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpa.entity.Employee;

//why @repository annotation is optinal
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByName(String name); 
    
    @Query("SELECT e FROM Employee e WHERE e.department = :dept")
    List<Employee> findByDepartment(@Param("dept") String dept);
    
    @Query(value = "SELECT * FROM employees WHERE name = ?1", nativeQuery = true)
    Employee findByNameNative(String name);
}