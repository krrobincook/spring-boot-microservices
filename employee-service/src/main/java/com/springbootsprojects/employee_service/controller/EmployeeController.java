package com.springbootsprojects.employee_service.controller;

import com.springbootsprojects.employee_service.dto.APIResponseDTO;
import com.springbootsprojects.employee_service.dto.EmployeeDto;
import com.springbootsprojects.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{Id}")
    public ResponseEntity<APIResponseDTO> getEmployeeById(@PathVariable("Id") Long id){
        APIResponseDTO apiResponseDTO = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }
}
