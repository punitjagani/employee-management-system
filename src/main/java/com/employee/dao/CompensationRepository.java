package com.employee.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.employee.data.Compensation;

/**
 * 
 * @author Punit Jagani
 *
 */
@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {
    Compensation findByEmployeeId(String employeeId);
}