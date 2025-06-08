package com.springbootsprojects.department_service.mapper;

import com.springbootsprojects.department_service.Entity.Department;
import com.springbootsprojects.department_service.dto.DepartmentDto;

public class DepartmentMapper {
    // convert JPA entity into dto
    public static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }

    public static Department mapToDepartment(DepartmentDto departmentDto){
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }
}
