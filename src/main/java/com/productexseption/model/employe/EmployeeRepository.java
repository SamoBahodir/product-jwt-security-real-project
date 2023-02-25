package com.productexseption.model.employe;

import com.productexseption.core.jpa_generic.JpaGenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaGenericRepository<Employee> {
}
