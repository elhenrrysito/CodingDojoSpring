package com.henrry.listaestudiantes.controllers;

import com.henrry.listaestudiantes.models.Contact;
import com.henrry.listaestudiantes.models.Dormitory;
import com.henrry.listaestudiantes.models.Student;
import com.henrry.listaestudiantes.services.ApiService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping("/dorms/create")
    public Dormitory createDormitory(@RequestParam("name") String name) {
        Dormitory dormitory = new Dormitory(name);
        return apiService.createDormitory(dormitory);
    }

    @GetMapping("/dorms/{id}")
    public List<Student> showStudentsFromDormitory(@PathVariable("id") Long id) {
        Dormitory dormitory = apiService.findDormitory(id);
        return dormitory.getStudents();
    }

    @PutMapping("/dorms/{id}/add")
    public Dormitory addStudentDormitory(@PathVariable("id") Long idDormitory, @RequestParam("student") Long idStudent) {
        Student student = apiService.findStudent(idStudent);
        Dormitory dormitory = apiService.findDormitory(idDormitory);
        student.setDormitory(dormitory);
        return apiService.updateDormitory(dormitory);
    }

    @DeleteMapping("/dorms/{id}/remove")
    public void removeStudentDormitory(@PathVariable("id") Long idDormitory, @RequestParam("student") Long idStudent) {
        apiService.deleteStudentFromDormitory(idStudent, idDormitory);
//        Dormitory dormitory = apiService.findDormitory(idDormitory);
//        Student student = apiService.findStudent(idStudent);
//        List<Student> students = dormitory.getStudents();
//        apiService.updateDormitory(dormitory);
//        dormitory.setStudents(students);

    }

}
