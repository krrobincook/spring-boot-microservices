package com.springbootsprojects.employee_service.service;

import com.springbootsprojects.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient( name = "DEPARTMENT-SERVICE")
//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{department-code}")
    DepartmentDto GetDepartmentByCode(@PathVariable("department-code") String code);
}
// OpenFeign library will dynamically create an implementation for this interface
// we don't have to write code to implement this interface
