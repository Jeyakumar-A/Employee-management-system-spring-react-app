package com.kumar.ems_backend.service;

import java.util.List;

import com.kumar.ems_backend.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(long employeeId);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployee(long employeeId,EmployeeDto updateEmployee);
     
    void deleteEmployee(Long employeeId);
}
