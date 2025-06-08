package com.springbootsprojects.employee_service.service;

import com.springbootsprojects.employee_service.dto.APIResponseDTO;
import com.springbootsprojects.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDTO getEmployeeById(Long id);
}
