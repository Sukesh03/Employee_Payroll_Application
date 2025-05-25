package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employeepayrollapp.exception.EmployeePayrollException;
import java.util.List;

@Slf4j
@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository repository;

    @Override
    public List<EmployeePayrollData> getAllEmployees() {
        log.info("Fetching all employees");
        return repository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeeById(int id) {
        log.info("Fetching employee by ID: {}", id);
        return repository.findById(id)
        		.orElseThrow(() -> new EmployeePayrollException("Employee with ID " + id + " not found"));
    }

    @Override
    public EmployeePayrollData createEmployee(EmployeePayrollDTO dto) {
        log.info("Creating new employee: {}", dto.getName());
        EmployeePayrollData employee = new EmployeePayrollData();
        employee.setName(dto.getName());
        employee.setSalary(dto.getSalary());
        EmployeePayrollData savedEmployee = repository.save(employee);
        log.debug("Created employee: {}", savedEmployee);
        return savedEmployee;
    }

    @Override
    public EmployeePayrollData updateEmployee(int id, EmployeePayrollDTO dto) {
        log.info("Updating employee with ID: {}", id);
        EmployeePayrollData employee = repository.findById(id)
            .orElseThrow(() -> {
                log.warn("Employee with ID {} not found for update", id);
                return new EmployeePayrollException("Employee with ID " + id + " not found");
            });
        
        employee.setName(dto.getName());
        employee.setSalary(dto.getSalary());
        EmployeePayrollData updatedEmployee = repository.save(employee);
        log.debug("Updated employee: {}", updatedEmployee);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(int id) {
        log.info("Deleting employee with ID: {}", id);
        boolean exists = repository.existsById(id);
        if (!exists) {
            log.warn("Employee with ID {} not found for delete", id);
            throw new EmployeePayrollException("Employee with ID " + id + " not found");
        }
        repository.deleteById(id);
        log.debug("Deleted employee with ID: {}", id);
    }

}
