package com.springbootsprojects.department_service.service;

import com.springbootsprojects.department_service.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto GetDepartmentByCode(String code);
}
