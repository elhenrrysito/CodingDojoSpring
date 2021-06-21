package com.henrry.listaestudiantes.repositories;

import com.henrry.listaestudiantes.models.Dormitory;
import com.henrry.listaestudiantes.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DormitoryRepository extends CrudRepository<Dormitory, Long> {
    List<Dormitory> findAll();
    Student findStudentById(Long id);
}

