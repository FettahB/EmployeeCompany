package com.example.crud.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    int id;
    String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_id", referencedColumnName = "id")
    @JsonBackReference
    Company company;
}
