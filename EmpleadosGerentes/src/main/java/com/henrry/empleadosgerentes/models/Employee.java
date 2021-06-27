package com.henrry.empleadosgerentes.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employees")
@Getter @Setter @NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="manager_id")
    private Employee manager;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    private List<Employee> employees;

    public Employee(String firstName, String lastName, List<Employee> employees) {
        this(firstName, lastName);
        this.employees = employees;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName, Employee manager, List<Employee> employees) {
        this(firstName, lastName);
        this.manager = manager;
        this.employees = employees;
    }

    public Employee(String firstName, String lastName, Employee manager) {
        this(firstName, lastName);
        this.manager = manager;
    }

    public void setEmployees(Employee employee) {
        this.employees.add(employee);
    }
}
