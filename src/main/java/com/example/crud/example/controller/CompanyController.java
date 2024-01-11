package com.example.crud.example.controller;

import com.example.crud.example.entity.Company;
import com.example.crud.example.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {


    @Autowired
    private CompanyService service;

    @PostMapping("/addCompany")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        Company savedCompany = service.saveCompany(company);
        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
    }

    @PostMapping("/addCompanies")
    public ResponseEntity<List<Company>> addCompanies(@RequestBody List<Company> companies) {
        List<Company> savedCompanies = service.saveCompanies(companies);
        return new ResponseEntity<>(savedCompanies, HttpStatus.CREATED);
    }

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> findAllCompanies() {
        List<Company> companies = service.getCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/companyById/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable int id) {
        Company company = service.getCompaniesById(id);
        return company != null
                ? new ResponseEntity<>(company, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/companyByName/{name}")
    public ResponseEntity<Company> findCompanyByName(@PathVariable String name) {
        Company company = service.getCompaniesByName(name);
        return company != null
                ? new ResponseEntity<>(company, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateCompany")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        Company updatedCompany = service.updateCompany(company);
        return updatedCompany != null
                ? new ResponseEntity<>(updatedCompany, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteCompany/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable int id) {
        String result = service.deleteCompany(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
