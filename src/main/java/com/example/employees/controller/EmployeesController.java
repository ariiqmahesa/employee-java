package com.example.employees.controller;

import com.example.employees.model.Employees;
import com.example.employees.repository.EmployeesRepositories;
import com.example.employees.service.EmployeesService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
@CrossOrigin()
public class EmployeesController {
    private EmployeesService repository;

    public EmployeesController(EmployeesService repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Collection<Employees> getAll() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<Employees> getById(@PathVariable Long id) {
        return repository.findById(id).stream().findFirst();
    }

    @DeleteMapping("/{id}")
    public Optional<Employees> deleteById(@PathVariable Long id) {
        return repository.deleteById(id);
    }

    @PostMapping("")
    public Employees insertEmployees(@RequestBody Employees employees) {
        return repository.save(employees);
    }
}