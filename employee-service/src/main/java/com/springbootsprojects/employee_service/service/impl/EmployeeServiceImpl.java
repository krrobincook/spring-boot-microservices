package com.springbootsprojects.employee_service.service.impl;

import com.springbootsprojects.employee_service.Entity.Employee;
import com.springbootsprojects.employee_service.dto.APIResponseDTO;
import com.springbootsprojects.employee_service.dto.DepartmentDto;
import com.springbootsprojects.employee_service.dto.EmployeeDto;
import com.springbootsprojects.employee_service.repository.EmployeeRepository;
import com.springbootsprojects.employee_service.service.APIClient;
import com.springbootsprojects.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    //private RestTemplate restTemplate;
    //private WebClient webClient;
    private APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
       Employee employee = modelMapper.map(employeeDto, Employee.class);
       // Employee employee = AutoEmployeeMapper.INSTANCE.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
        //EmployeeDto savedEmployeeDto = AutoEmployeeMapper.INSTANCE.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }


    @Override
    public APIResponseDTO getEmployeeById(Long id) {

        Employee getEmployeeById = employeeRepository.findById(id).get();
        // -> Rest Template
    //    ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + getEmployeeById.getDepartmentCode()
    //            , DepartmentDto.class); // -> This line makes a REST call to another microservice
        // to fetch department details by departmentCode.
    //    DepartmentDto departmentDto = responseEntity.getBody(); // This retrieves the actual
        // department data from the response body.

        // -> Web client
    //    DepartmentDto departmentDto = webClient.get().
    //            uri("http://localhost:8080/api/departments/"
    //              +getEmployeeById.getDepartmentCode()).retrieve()
    //                    .bodyToMono(DepartmentDto.class).block();
        // -> API client
        DepartmentDto departmentDto = apiClient.GetDepartmentByCode
                                      (getEmployeeById.getDepartmentCode());
        EmployeeDto getEmployeeByIdDto = modelMapper.map(getEmployeeById, EmployeeDto.class);
        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setEmployee(getEmployeeByIdDto);
        apiResponseDTO.setDepartment(departmentDto);
        //Combines both EmployeeDto and DepartmentDto into a single response DTO.
        return apiResponseDTO;
        //return AutoEmployeeMapper.INSTANCE.mapToEmployeeDto(getEmployeeById);
    }
}
