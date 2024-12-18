package com.kumar.ems_backend.mapper;

import com.kumar.ems_backend.dto.EmployeeDto;
import com.kumar.ems_backend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        
        return new  EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastNmae(),
            employee.getEmail()
        );

    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
            employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmail()
        );
    }
}
