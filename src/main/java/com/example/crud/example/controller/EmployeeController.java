package com.example.crud.example.controller;

import com.example.crud.example.entity.Employee;
import com.example.crud.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = service.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PostMapping("/addEmployees")
    public ResponseEntity<List<Employee>> addEmployees(@RequestBody List<Employee> employees) {
        List<Employee> savedEmployees = service.saveEmployees(employees);
        return new ResponseEntity<>(savedEmployees, HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> employees = service.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employeeById/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id) {
        Employee employee = service.getEmployeeById(id);
        return employee != null
                ? new ResponseEntity<>(employee, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/employeeByName/{name}")
    public ResponseEntity<Employee> findEmployeeByName(@PathVariable String name) {
        Employee employee = service.getEmployeesByName(name);
        return employee != null
                ? new ResponseEntity<>(employee, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        String result = service.deleteEmployee(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = service.updateEmployee(employee);
        return updatedEmployee != null
                ? new ResponseEntity<>(updatedEmployee, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
