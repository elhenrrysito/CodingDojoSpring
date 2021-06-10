package com.henrry.lenguajes.repositories;

import com.henrry.lenguajes.models.Lenguaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LenguajeRepository extends CrudRepository<Lenguaje, Long> {
    // Este método recupera todos los lenguajes de la base de datos
    List<Lenguaje> findAll();
    //Este método encuentra un lenguaje por su nombre
    List<Lenguaje> findByNameContaining(String search);
    //Este método borra un lenguaje que empieza con un nombre específico
    Long deleteByNameStartingWith(String search);
}
