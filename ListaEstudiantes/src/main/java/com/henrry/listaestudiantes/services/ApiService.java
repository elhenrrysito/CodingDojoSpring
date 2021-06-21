package com.henrry.listaestudiantes.services;

import com.henrry.listaestudiantes.models.Contact;
import com.henrry.listaestudiantes.models.Dormitory;
import com.henrry.listaestudiantes.models.Student;
import com.henrry.listaestudiantes.repositories.ContactRepository;
import com.henrry.listaestudiantes.repositories.DormitoryRepository;
import com.henrry.listaestudiantes.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiService {
    private final StudentRepository studentRepository;
    private final ContactRepository contactRepository;
    private final DormitoryRepository dormitoryRepository;

    public ApiService(StudentRepository studentRepository, ContactRepository contactRepository, DormitoryRepository dormitoryRepository) {
        this.studentRepository = studentRepository;
        this.contactRepository = contactRepository;
        this.dormitoryRepository = dormitoryRepository;
    }

    // STUDENTS

    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            return null;
        }
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // CONTACTS

    public List<Contact> allContacts() {
        return contactRepository.findAll();
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact findContact(Long id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if(optionalContact.isPresent()) {
            return optionalContact.get();
        } else {
            return null;
        }
    }

    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    // DORMITORIES

    public List<Dormitory> allDormitories() {
        return dormitoryRepository.findAll();
    }

    public Dormitory createDormitory(Dormitory dormitory) {
        return dormitoryRepository.save(dormitory);
    }

    public Dormitory findDormitory(Long id) {
        Optional<Dormitory> optionalDormitory = dormitoryRepository.findById(id);
        if(optionalDormitory.isPresent()) {
            return optionalDormitory.get();
        } else {
            return null;
        }
    }

    public Dormitory updateDormitory(Dormitory dormitory) {
        return dormitoryRepository.save(dormitory);
    }

    public void deleteDormitory(Long id) {
        dormitoryRepository.deleteById(id);
    }

    public void deleteStudentFromDormitory(Long idStudent, Long idDormitory) {
        List<Student> students = findDormitory(idDormitory).getStudents();
        Student student = findStudent(idStudent);
        student.setDormitory(null);
        studentRepository.save(student);
    }


}
