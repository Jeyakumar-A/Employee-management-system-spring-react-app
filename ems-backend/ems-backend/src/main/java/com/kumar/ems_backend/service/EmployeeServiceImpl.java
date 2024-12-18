package com.kumar.ems_backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kumar.ems_backend.dto.EmployeeDto;
import com.kumar.ems_backend.entity.Employee;
import com.kumar.ems_backend.exception.ResourceNotFoundException;
import com.kumar.ems_backend.mapper.EmployeeMapper;
import com.kumar.ems_backend.repository.EmployeeRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // TODO Auto-generated method stub
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee createEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(createEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(long employeeId) {
        // TODO Auto-generated method stub
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not existed with given id"+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        // TODO Auto-generated method stub
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(long employeeId, EmployeeDto updateEmployee) {
        // TODO Auto-generated method stub

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not existed with given id "+employeeId));

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastNmae(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);


    }

    @Override
    public void deleteEmployee(Long employeeId) {
        // TODO Auto-generated method stub
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not existed with given id "+employeeId));
            
        employeeRepository.deleteById(employeeId);
        
    }


}
