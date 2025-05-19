package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    List<EmployeePayrollData> getAllEmployees();
    EmployeePayrollData getEmployeeById(int id);
    EmployeePayrollData createEmployee(EmployeePayrollDTO dto);
    EmployeePayrollData updateEmployee(int id, EmployeePayrollDTO dto);
    void deleteEmployee(int id);
}
