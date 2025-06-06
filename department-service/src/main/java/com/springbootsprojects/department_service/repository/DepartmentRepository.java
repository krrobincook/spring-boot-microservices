package com.springbootsprojects.department_service.repository;

import com.springbootsprojects.department_service.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepartmentCode(String departmentCode);
}
