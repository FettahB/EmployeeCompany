package com.example.crud.example.service;

import com.example.crud.example.entity.Employee;
import com.example.crud.example.repository.EmployeeRepository;
import org.hibernate.sql.results.graph.embeddable.EmbeddableLoadingLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }
    public List<Employee> saveEmployees(List<Employee> employees){
        return repository.saveAll(employees);
    }

    public List<Employee> getEmployees(){
        return repository.findAll();
    }

    public Employee getEmployeeById(int id){
        return repository.findById(id).orElse(null);
    }
    public Employee getEmployeesByName(String name){
        return repository.findByName(name);
    }

    public String deleteEmployee(int id){
        repository.deleteById(id);
        return "Employee " + id + "removed";
    }

    public Employee updateEmployee(Employee employee){
        Employee existingEmloyee = repository.findById(employee.getId()).orElse(null);
        existingEmloyee.setName(employee.getName());
        existingEmloyee.setCompany(employee.getCompany());
        return repository.save(existingEmloyee);
    }

}
