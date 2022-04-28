package com.employee.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.CompensationRepository;
import com.employee.dao.EmployeeRepository;
import com.employee.data.Compensation;
import com.employee.data.Employee;
import com.employee.service.CompensationService;

@Service
public class CompensationServiceImpl implements CompensationService{
	
	
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private CompensationRepository compensationRepository;
    
	/**
     * Creates and saves the compensation object for the given employee id
     */
	@Override
    public Compensation createCompensation(Compensation compensation) {
        LOG.debug("Creating Compensation [{}]", compensation);

        compensation.setEmployeeId(compensation.getEmployeeId());
        compensationRepository.insert(compensation);
        compensation.setEmployee(employeeRepository.findByEmployeeId(compensation.getEmployeeId()));
        return compensation;
    }
    
	/**
	 * Reads compensation details based on employee id
	 */
    @Override
    public Compensation readCompensation(String employeeId) {
    	  LOG.debug("Reading Compensation with employee id [{}]", employeeId);

    	  Compensation compensation = compensationRepository.findByEmployeeId(employeeId);
    	  Employee employee = employeeRepository.findByEmployeeId(employeeId);
    	 
    	  if (compensation == null) {
              throw new RuntimeException("No compensation record found for employee id " + employeeId);
          }
          compensation.setEmployee(employee);

          return compensation;
    }

}
