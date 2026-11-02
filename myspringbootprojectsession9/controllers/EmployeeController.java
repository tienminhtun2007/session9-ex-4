package com.example.myspringbootprojectsession9.controllers;

import com.example.myspringbootprojectsession9.dto.ApiResponse;
import com.example.myspringbootprojectsession9.dto.EmployeeCreateDTO;
import com.example.myspringbootprojectsession9.entities.Employee;
import com.example.myspringbootprojectsession9.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> createEmployee(
            @Valid @RequestBody EmployeeCreateDTO request) {
        Employee employee = employeeService.createEmployee(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("SUCCESS", "Tạo nhân viên thành công", employee));
    }
}
