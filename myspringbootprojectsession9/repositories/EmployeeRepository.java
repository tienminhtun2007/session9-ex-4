package com.example.myspringbootprojectsession9.repositories;

import com.example.myspringbootprojectsession9.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByEmail(String email);
}
