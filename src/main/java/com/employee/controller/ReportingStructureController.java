package com.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.data.ReportingStructure;
import com.employee.service.ReportingStructureService;

@RestController
@RequestMapping("/reportingStructure")
public class ReportingStructureController {
	
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private ReportingStructureService reportingStructureService;
	
    /**
     * Gets total number of reportees under an employee 
     * @param id
     * @return ReportingStructure object which contains total number of reports under an employee
     */
    @GetMapping("/getNoOfReports/{id}")
    public ReportingStructure getNoOfReports(@PathVariable String id) {
        LOG.debug("Received request to get total number of reportees for id [{}]", id);

        return reportingStructureService.getNoOfReports(id);
    } 

}
