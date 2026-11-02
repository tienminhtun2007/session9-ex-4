package com.example.myspringbootprojectsession9.services;

import com.example.myspringbootprojectsession9.dto.DepartmentDTO;
import com.example.myspringbootprojectsession9.entities.Department;
import com.example.myspringbootprojectsession9.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public Department createDepartment(DepartmentDTO request) {
        Department department = new Department(request.getName(), request.getDescription());
        return departmentRepository.save(department);
    }
}
