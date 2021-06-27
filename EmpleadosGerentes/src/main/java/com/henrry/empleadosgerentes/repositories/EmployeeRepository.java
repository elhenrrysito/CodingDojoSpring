package com.henrry.empleadosgerentes.repositories;

import com.henrry.empleadosgerentes.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAll();
    List<Employee> findByManagerContaining(Employee employee); // s
}
