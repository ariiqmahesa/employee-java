package com.example.employees.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Division {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private @NonNull String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
