package com.example.employees.service;


import com.example.employees.model.Employees;
import com.example.employees.repository.EmployeesRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {
    private final EmployeesRepositories employeesRepository;

    public EmployeesService(EmployeesRepositories employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<Employees> findAll() {
        return employeesRepository.findAll();
    }

    public Optional<Employees> findById(Long id) {
        return employeesRepository.findById(id);
    }

    public Optional<Employees> deleteById(Long id) {
        employeesRepository.deleteById(id);
        return Optional.empty();
    }

    public Employees save(Employees employees) {
        if(employees.getId() == null){
            return employeesRepository.save(employees);
        }else{
            Employees employeesToUpdate = employeesRepository.getOne(employees.getId());
            employeesToUpdate.setNik(employees.getNik());
            employeesToUpdate.setName(employees.getName());
            employeesToUpdate.setDivisionId(employees.getDivisionId());
            employeesToUpdate.setPositionId(employees.getPositionId());
            employeesToUpdate.setLastPosition(employees.getLastPosition());
            employeesToUpdate.setType(employees.getType());
            return employeesRepository.save(employeesToUpdate);
        }
    }
}
