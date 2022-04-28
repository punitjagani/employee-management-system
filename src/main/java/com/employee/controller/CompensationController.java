package com.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.data.Compensation;
import com.employee.service.CompensationService;

@RestController
@RequestMapping("/compensation")
public class CompensationController {
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	
    @Autowired
    private CompensationService compensationService;
	
    /**
     * Creates and saves the compensation object for the given employee id
     * @param compensation
     * @return compensation object 
     */
    @PostMapping("/insertCompensation")
    public Compensation create(@RequestBody Compensation compensation) {
        LOG.debug("Received create request for compensation", compensation);

        return compensationService.createCompensation(compensation);
    }
    
    /**
     * Gets compensation details based on employee id
     * @param id
     * @return compensation details
     */
    @GetMapping("/getCompensation/{id}")
    public Compensation readCompensation(@PathVariable String id) {
        LOG.debug("Received read request for compensation by id [{}]", id);

        return compensationService.readCompensation(id);
    }

}
