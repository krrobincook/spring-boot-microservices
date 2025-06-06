package com.springbootsprojects.employee_service.repository;

import com.springbootsprojects.employee_service.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
