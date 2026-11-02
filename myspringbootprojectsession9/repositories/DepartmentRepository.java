package com.example.myspringbootprojectsession9.repositories;

import com.example.myspringbootprojectsession9.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
