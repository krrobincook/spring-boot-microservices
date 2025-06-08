package com.springbootsprojects.department_service.service.impl;

import com.springbootsprojects.department_service.Entity.Department;
import com.springbootsprojects.department_service.dto.DepartmentDto;
import com.springbootsprojects.department_service.mapper.AutoDepartmentMapper;
import com.springbootsprojects.department_service.repository.DepartmentRepository;
import com.springbootsprojects.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //Department department = modelMapper.map(departmentDto, Department.class);
        Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        //DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);
        DepartmentDto savedDepartmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto GetDepartmentByCode(String departmentCode) {
        Optional<Department> optionaldepartment = Optional.ofNullable(departmentRepository.findByDepartmentCode(departmentCode));
        Department department = optionaldepartment.get();
        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(optionaldepartment.get());
    }
}
