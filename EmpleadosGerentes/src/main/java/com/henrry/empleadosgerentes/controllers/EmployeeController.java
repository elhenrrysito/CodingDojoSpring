package com.henrry.empleadosgerentes.controllers;

import com.henrry.empleadosgerentes.models.Employee;
import com.henrry.empleadosgerentes.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/newManager")
    public String newManager(@ModelAttribute("manager") Employee employee) {
        return "employee/newManager.jsp";
    }

    @PostMapping("/newManager")
    public String addManager(@Valid @ModelAttribute("manager") Employee employee, BindingResult result) {
        if(result.hasErrors()) {
            return "employee/newManager.jsp";
        } else {
            employeeService.createEmployee(employee);
            return "redirect:/"; // <-- OJO
        }
    }

    @GetMapping("{id}/newEmployee")
    public String newEmployee(@ModelAttribute("employee") Employee employee, @PathVariable("id") Long id,
                              Model model) {
        Employee manager = employeeService.findEmployee(id);
        model.addAttribute("manager", manager);
        return "employee/newEmployee.jsp";
    }

    @PostMapping("{idManager}/newEmployee")
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employee, @PathVariable("idManager") Long idManager, BindingResult result) {
        if(result.hasErrors()) {
            return "employee/newEmployee.jsp";
        } else {
            Employee manager = employeeService.findEmployee(idManager);
            employee.setManager(manager);
            System.out.println(employee.getFirstName());
            System.out.println(employee.getId());
            System.out.println(manager.getFirstName());
            System.out.println(manager.getId());
            employeeService.createEmployee(employee);
            return "redirect:/"; // <-- OJO
        }
    }

    @GetMapping("/manager/{id}")
    public String showManager(@PathVariable("id") Long id, Model model) {
        Employee manager = employeeService.findEmployee(id);
        model.addAttribute("manager", manager);
        return "employee/showManager.jsp";
    }

    @GetMapping("{id}")
    public String showEmployee(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeService.findEmployee(id);
        model.addAttribute("employee", employee);
        return "employee/showEmployee.jsp";
    }
}
