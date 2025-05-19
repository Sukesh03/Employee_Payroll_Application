package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository repository;

    @Override
    public List<EmployeePayrollData> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeeById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public EmployeePayrollData createEmployee(EmployeePayrollDTO dto) {
        EmployeePayrollData employee = new EmployeePayrollData();
        employee.setName(dto.getName());
        employee.setSalary(dto.getSalary());
        return repository.save(employee);
    }

    @Override
    public EmployeePayrollData updateEmployee(int id, EmployeePayrollDTO dto) {
        EmployeePayrollData employee = repository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(dto.getName());
            employee.setSalary(dto.getSalary());
            return repository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
}
