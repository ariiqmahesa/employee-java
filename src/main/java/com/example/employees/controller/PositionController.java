package com.example.employees.controller;

import com.example.employees.model.Division;
import com.example.employees.model.Position;
import com.example.employees.service.PositionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/position")
@CrossOrigin()
public class PositionController {
    private PositionService repository;

    public PositionController(PositionService repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Collection<Position> getAll() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<Position> getById(@PathVariable Long id) {
        return repository.findById(id).stream().findFirst();
    }

    @DeleteMapping("/{id}")
    public Optional<Position> deleteById(@PathVariable Long id) {
        return repository.deleteById(id);
    }

    @PostMapping("")
    public Position insertEmployees(@RequestBody Position position) {
        return repository.save(position);
    }
}
