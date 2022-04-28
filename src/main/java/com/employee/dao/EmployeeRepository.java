package com.employee.dao;

import org.springframework.stereotype.Repository;

import com.employee.data.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findByEmployeeId(String employeeId);
}
