package com.example.employees.repository;

import com.example.employees.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DivisionRepository extends JpaRepository<Division, Long> {

}
