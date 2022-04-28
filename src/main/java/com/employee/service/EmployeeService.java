package com.employee.service;

import com.employee.data.Employee;

public interface EmployeeService {
    Employee create(Employee employee);
    Employee read(String id);
    Employee update(Employee employee);
}
