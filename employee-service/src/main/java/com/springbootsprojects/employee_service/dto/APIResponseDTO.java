package com.springbootsprojects.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class APIResponseDTO {
    private EmployeeDto employee;
    private DepartmentDto department;
}
