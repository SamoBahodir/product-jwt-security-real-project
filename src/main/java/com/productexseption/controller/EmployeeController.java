package com.productexseption.controller;

import com.productexseption.config.SwaggerConfig;
import com.productexseption.core.SuccessfulResponse;
import com.productexseption.exception.ResourceNotFoundException;
import com.productexseption.model.employe.Employee;
import com.productexseption.model.employe.EmployeeRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
@SecurityRequirement(name = SwaggerConfig.BEARER)
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @GetMapping("/getAll")
    public SuccessfulResponse<List<Employee>> getAll() {
        return new SuccessfulResponse<>(employeeRepository.findAll());
    }

    @PostMapping("/create")
    public SuccessfulResponse<Employee> create(@RequestBody Employee employee) {
        return new SuccessfulResponse<>(employeeRepository.save(employee));
    }

    @GetMapping("/getId/{id}")
    public SuccessfulResponse<Employee> getId(@PathVariable Long id) throws ResourceNotFoundException {
        Employee byId = employeeRepository
                .findById(id).orElseThrow(()
                        -> new ResourceNotFoundException("Employee not found for this id" + id));
        return new SuccessfulResponse<>(byId);
    }

    @PutMapping("/update/{id}")
    public SuccessfulResponse<Employee> update(@PathVariable Long id, @RequestBody Employee employee) throws ResourceNotFoundException {
        Employee byId = employeeRepository
                .findById(id).orElseThrow(()
                        -> new ResourceNotFoundException("Employee not found for this id" + id));
        byId.setEmail(employee.getEmail());
        byId.setFirstName(employee.getFirstName());
        byId.setLastName(employee.getLastName());
        return new SuccessfulResponse<>(employeeRepository.save(byId));
    }

    @DeleteMapping("/delete/{id}")
    public SuccessfulResponse<Void> delete(@PathVariable Long id) throws ResourceNotFoundException {
        Employee byId = employeeRepository
                .findById(id).orElseThrow(()
                        -> new ResourceNotFoundException("Employee not found for this id" + id));
        employeeRepository.delete(byId);
       return new SuccessfulResponse<>();
    }
}
