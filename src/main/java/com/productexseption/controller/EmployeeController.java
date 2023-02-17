package com.productexseption.controller;

import com.productexseption.exception.ResourceNotFoundException;
import com.productexseption.model.employe.Employee;
import com.productexseption.model.employe.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<Employee> getId(@PathVariable Long id) throws ResourceNotFoundException {
        Employee byId = employeeRepository
                .findById(id).orElseThrow(()
                        -> new ResourceNotFoundException("Employee not found for this id" + id));
        return ResponseEntity.ok().body(byId);
    }

    @PutMapping("/update/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) throws ResourceNotFoundException {
        Employee byId = employeeRepository
                .findById(id).orElseThrow(()
                        -> new ResourceNotFoundException("Employee not found for this id" + id));
        byId.setEmail(employee.getEmail());
        byId.setFirstName(employee.getFirstName());
        byId.setLastName(employee.getLastName());
        return employeeRepository.save(byId);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        Employee byId = employeeRepository
                .findById(id).orElseThrow(()
                        -> new ResourceNotFoundException("Employee not found for this id" + id));
        employeeRepository.delete(byId);
    }
}
