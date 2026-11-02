package com.example.myspringbootprojectsession9.services;

import com.example.myspringbootprojectsession9.dto.EmployeeCreateDTO;
import com.example.myspringbootprojectsession9.entities.Department;
import com.example.myspringbootprojectsession9.entities.Employee;
import com.example.myspringbootprojectsession9.exceptions.ResourceNotFoundException;
import com.example.myspringbootprojectsession9.exceptions.DuplicateResourceException;
import com.example.myspringbootprojectsession9.repositories.DepartmentRepository;
import com.example.myspringbootprojectsession9.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository,
                           DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public Employee createEmployee(EmployeeCreateDTO request) {
        if (employeeRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email đã được sử dụng");
        }

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Phòng ban không tồn tại"));
        Employee employee = new Employee(
                request.getFullName(),
                request.getEmail(),
                request.getPhone(),
                request.getSalary(),
                department
        );
        return employeeRepository.save(employee);
    }
}
