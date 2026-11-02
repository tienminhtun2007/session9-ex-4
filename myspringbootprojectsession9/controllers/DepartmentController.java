package com.example.myspringbootprojectsession9.controllers;

import com.example.myspringbootprojectsession9.dto.DepartmentDTO;
import com.example.myspringbootprojectsession9.dto.ApiResponse;
import com.example.myspringbootprojectsession9.entities.Department;
import com.example.myspringbootprojectsession9.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Department>> createDepartment(
            @Valid @RequestBody DepartmentDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        "SUCCESS",
                        "Tạo phòng ban thành công",
                        departmentService.createDepartment(request)
                ));
    }
}
