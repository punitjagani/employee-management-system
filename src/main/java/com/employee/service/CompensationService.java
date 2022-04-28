package com.employee.service;

import com.employee.data.Compensation;

public interface CompensationService {
    Compensation createCompensation(Compensation compensation);
    Compensation readCompensation(String employeeId);
}
