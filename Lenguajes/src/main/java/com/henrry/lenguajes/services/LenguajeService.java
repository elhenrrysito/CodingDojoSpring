package com.henrry.lenguajes.services;

import com.henrry.lenguajes.models.Lenguaje;
import com.henrry.lenguajes.repositories.LenguajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LenguajeService {
    //Agregando el book al repositorio como una dependencia
    private final LenguajeRepository lenguajeRepository;

    public LenguajeService(LenguajeRepository lenguajeRepository) {
        this.lenguajeRepository = lenguajeRepository;
    }

    // Devolviendo todos los lenguajes
    public List<Lenguaje> allLenguajes() {
        return lenguajeRepository.findAll();
    }

    // Creando un lenguaje
    public Lenguaje createLenguaje(Lenguaje l) {
        return lenguajeRepository.save(l);
    }

    // Obteniendo la informacion de un lenguaje
    public Lenguaje findLenguaje(Long id) {
        Optional<Lenguaje> optionalLenguaje = lenguajeRepository.findById(id);
        if(optionalLenguaje.isPresent()) {
            return optionalLenguaje.get();
        } else {
            return null;
        }
    }

    // Actualizando un lenguaje
    public Lenguaje updateLenguaje(Lenguaje lenguaje) {
        return lenguajeRepository.save(lenguaje);
    }

    // Eliminando un lenguaje
    public void deleteLenguaje(Long id) {
        lenguajeRepository.deleteById(id);
    }
}
