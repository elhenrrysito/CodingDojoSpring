package com.henrry.empleadosgerentes.controllers;

import com.henrry.empleadosgerentes.models.Employee;
import com.henrry.empleadosgerentes.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApi {
    private final EmployeeService employeeService;

    public EmployeeApi(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> allEmployees() {
        return employeeService.allEmployees();
    }

    @PostMapping("/newManager")
    public Employee newManager(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employeeService.createEmployee(employee);
    }

    @PostMapping("/{id}/newEmployee")
    public Employee newEmployee(@PathVariable("id") Long id,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName) {
        Employee manager = employeeService.findEmployee(id);
        Employee employee = new Employee(firstName, lastName, manager);
        return employeeService.createEmployee(employee);
    }

    // Obtener los empleados del manager, pasando el id del manager
    @GetMapping("/{id}")
    public Employee showManagerEmployees(@PathVariable("id") Long id) {
        return employeeService.findEmployee(id);
    }






}
