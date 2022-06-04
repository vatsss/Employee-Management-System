package com.example.vats.employeedata.controller;

import com.example.vats.employeedata.model.Employee;
import com.example.vats.employeedata.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    //GET
    @RequestMapping("/employee")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }
    //POST
    @RequestMapping(method= RequestMethod.POST,value="/employee")
    public Employee createEmployee(@RequestBody Employee emp){
        return employeeService.createEmployee(emp);
    }
    //UPDATE
    @RequestMapping(method=RequestMethod.PUT,value="/employee/{id}")
    public void updateEmployee(@PathVariable(value="id") Long empId, @RequestBody Employee emp){
        employeeService.updateEmployee(empId,emp);
    }
    //DELETE
    @RequestMapping(method = RequestMethod.DELETE,value="/employee/{id}")
    public void deleteEmployee(@PathVariable(value="id") Long empId){
        employeeService.deleteEmployee(empId);
    }
}

