package com.example.crud.example.service;

import com.example.crud.example.entity.Company;
import com.example.crud.example.entity.Employee;
import com.example.crud.example.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository repository;

    public Company saveCompany(Company company){
       return repository.save(company);
    }
    public List<Company> saveCompanies(List<Company> companies){
        return repository.saveAll(companies);
    }

    public List<Company> getCompanies(){
        return repository.findAll();
    }

    public Company getCompaniesById(int id){
        return repository.findById(id).orElse(null);
    }
    public Company getCompaniesByName(String name){
        return repository.findByName(name);
    }

    public String deleteCompany(int id){
        repository.deleteById(id);
        return "Company " + id + "removed.";
    }

    public Company updateCompany(Company company){
        Company existingCompany =repository.findById(company.getId()).orElse(null);
        existingCompany.setName(company.getName());
        existingCompany.setAddress(company.getAddress());
        return repository.save(existingCompany);
    }
}
