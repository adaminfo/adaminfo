package com.xeness.js.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.xeness.js.model.Employee;
import com.xeness.js.repository.EmployeeRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
 
@RestController  
public class MainRESTController {
 
    @Autowired
    private EmployeeRepository employeeRepository;
 
 
    // URL:
    // http://localhost:8080/SomeContextPath/employees
    // http://localhost:8080/SomeContextPath/employees.xml
    // http://localhost:8080/SomeContextPath/employees.json
    @ApiOperation(value = "Test test test")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 403, message = "Internal server error")
    })
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
 
    // URL:
    // http://localhost:8080/SomeContextPath/employee/{empId}
    // http://localhost:8080/SomeContextPath/employee/{empId}.xml
    // http://localhost:8080/SomeContextPath/employee/{empId}.json
    @GetMapping("/employee/{empId}")
    public Employee getEmployee(@PathVariable("empId") Long empId) {
        return employeeRepository.findById(empId).get();
    }
 
    // URL:
    // http://localhost:8080/SomeContextPath/employee
    // http://localhost:8080/SomeContextPath/employee.xml
    // http://localhost:8080/SomeContextPath/employee.json
 
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee emp) {
 
        System.out.println("(Service Side) Creating employee with empNo: " + emp.getEmpNo());
 
        return employeeRepository.save(emp);
    }
 
    // URL:
    // http://localhost:8080/SomeContextPath/employee
    // http://localhost:8080/SomeContextPath/employee.xml
    // http://localhost:8080/SomeContextPath/employee.json

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee empDetails) {
 
        System.out.println("(Service Side) Editing employee with Id: " + empDetails.getEmpId());
        
        Employee emp = employeeRepository.findById(empDetails.getEmpId()).get();
        emp.setEmpName(empDetails.getEmpName());
        emp.setEmpNo(empDetails.getEmpNo());
        emp.setPosition(empDetails.getPosition());
 
        return employeeRepository.save(emp);
    }
 
    // URL:
    // http://localhost:8080/SomeContextPath/employee/{empId}
    @DeleteMapping("/employee/{empId}")
    public void deleteEmployee(@PathVariable("empId") Long empId) {
 
        System.out.println("(Service Side) Deleting employee with Id: " + empId);
        Employee emp = employeeRepository.findById(empId).get();
        employeeRepository.delete(emp);
    }
 
}
