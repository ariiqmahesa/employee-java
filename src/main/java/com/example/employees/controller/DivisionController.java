package com.example.employees.controller;

import com.example.employees.model.Division;
import com.example.employees.service.DivisionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/division")
@CrossOrigin()
public class DivisionController {
    private DivisionService repository;

    public DivisionController(DivisionService repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Collection<Division> getAll() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<Division> getById(@PathVariable Long id) {
        return repository.findById(id).stream().findFirst();
    }

    @DeleteMapping("/{id}")
    public Optional<Division> deleteById(@PathVariable Long id) {
        return repository.deleteById(id);
    }

    @PostMapping("")
    public Division insertEmployees(@RequestBody Division division) {
        return repository.save(division);
    }
}
