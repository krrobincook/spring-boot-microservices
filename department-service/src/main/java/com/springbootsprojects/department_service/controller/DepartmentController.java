package com.springbootsprojects.department_service.controller;

import com.springbootsprojects.department_service.dto.DepartmentDto;
import com.springbootsprojects.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {
    private DepartmentService departmentService;
    //Build save department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> savedDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    //Build Get department REST API
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> GetDepartmentByCode(@PathVariable("department-code")
                                                                 String code){
        DepartmentDto getDepartmentCode = departmentService.GetDepartmentByCode(code);
        return new ResponseEntity<>(getDepartmentCode, HttpStatus.OK);
    }
}
