package com.example.vats.employeedata.service;

import com.example.vats.employeedata.model.Employee;
import com.example.vats.employeedata.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    //CREATE
    public Employee createEmployee(Employee emp){
        return employeeRepository.save(emp);
    }
    //READ
    public List<Employee> getAllEmployees(){
        List<Employee> emp = new ArrayList<>();
        employeeRepository.findAll().forEach(emp::add);
        return emp;
        //return employeeRepository.findAll();
    }
    //UPDATE
    public void updateEmployee(Long empId,Employee updatedEmployee){
        Employee emp = employeeRepository.findById(empId).get();
        emp.setEmpId(updatedEmployee.getEmpId());
        emp.setFirstName(updatedEmployee.getFirstName());
        emp.setLastName(updatedEmployee.getLastName());
        emp.setEmailId(updatedEmployee.getEmailId());

        employeeRepository.save(emp);
    }
    //DELETE
    public void deleteEmployee(Long empId){
        employeeRepository.deleteById(empId);
    }
}
