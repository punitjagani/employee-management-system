package com.employee.service.impl;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeRepository;
import com.employee.data.Employee;
import com.employee.data.ReportingStructure;
import com.employee.service.ReportingStructureService;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService{
	
	int count=0;
	HashSet<String> empSet=new HashSet<>();
	    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	    @Autowired
	    private EmployeeRepository employeeRepository;
	    	    
	    /**
	     * Computes the total number of reports under an employee based on employee id
	     */
	    @Override
	    public ReportingStructure getNoOfReports(String employeeId) {
			LOG.debug("Getting no of reports for employee with id [{}]", employeeId);
			
			Employee employee = employeeRepository.findByEmployeeId(employeeId);
		
		    if (employee == null) {
		        throw new RuntimeException("Invalid employeeId: " + employeeId);
		    }
		    
		    //if there are no direct reports under an employee then return 0
		    if(employee.getDirectReports()==null) {
		    	ReportingStructure rs=new ReportingStructure(employee, 0);
		    	rs.setNumberOfReports(0);
		    	return rs;
		    }
		    
		   ReportingStructure rs=new ReportingStructure(employee, employee.getDirectReports().size());
	       count=0;
	       empSet=new HashSet<>();
	       count= countDirectReports(employeeId, employee);
	       rs.setNumberOfReports(count);
	       return rs;
	    }
	    
	    /**
	     * Gets total number of direct reports under an employee
	     * @param employeeId
	     * @param employee
	     * @return count total number of direct reports under an employee
	     */
	   
	    private int countDirectReports(String employeeId, Employee employee) {

	    	if(employee.getDirectReports()==null) {
	    		return count;
	    	}
	    	else {
	    		//count+=employee.getDirectReports().size();
	    		for(Employee emp:employee.getDirectReports()) {
	    			if(!empSet.contains(emp.getEmployeeId())) {
	    				empSet.add(emp.getEmployeeId());
	    				count+=1;
	    			}
	    		}
	    		//Recursively call countDirectReports till we get count of direct reports null
	    		for(Employee emp:employee.getDirectReports()) {
	    			countDirectReports(emp.getEmployeeId(), employeeRepository.findByEmployeeId(emp.getEmployeeId()));
	    		}
	    	}
	    	return count;
		}
}
