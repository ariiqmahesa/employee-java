package com.example.employees.repository;

import com.example.employees.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeesRepositories extends JpaRepository<Employees, Long> {
}
