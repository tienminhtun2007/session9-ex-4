package com.example.myspringbootprojectsession9.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DepartmentDTO {

    @NotBlank(message = "name không được để trống")
    @Size(min = 5, max = 50, message = "name phải có từ 5 đến 50 ký tự")
    private String name;

    @Size(max = 100, message = "description không được vượt quá 100 ký tự")
    private String description;

    public DepartmentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
