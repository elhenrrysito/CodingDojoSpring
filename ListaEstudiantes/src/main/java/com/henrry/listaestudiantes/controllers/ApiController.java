package com.henrry.listaestudiantes.controllers;

import com.henrry.listaestudiantes.models.Contact;
import com.henrry.listaestudiantes.models.Student;
import com.henrry.listaestudiantes.services.ApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping(value="/students/create", method = RequestMethod.POST)
    public Student createStudent(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("age") int age) {
        Student student = new Student(firstName, lastName, age);
        return apiService.createStudent(student);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> showStudents() {
        return apiService.allStudents();
    }

    @RequestMapping(value = "/contacts/create")
    public Contact createContact(@RequestParam("student") Long id,
                                 @RequestParam("address") String address,
                                 @RequestParam("city") String city,
                                 @RequestParam("state") String state) {
        Student student = apiService.findStudent(id);
        Contact contact = new Contact(address, city, state, student);
        return apiService.createContact(contact);
    }



}
