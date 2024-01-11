package com.example.crud.example.repository;

import com.example.crud.example.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findByName(String name);
}
