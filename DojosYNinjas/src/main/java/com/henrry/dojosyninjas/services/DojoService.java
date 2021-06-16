package com.henrry.dojosyninjas.services;

import com.henrry.dojosyninjas.models.Dojo;
import com.henrry.dojosyninjas.repositories.DojoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }

    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }

    public Dojo findDojo(Long id) {
        Optional<Dojo> dojoOptional = dojoRepository.findById(id);
        if(dojoOptional.isPresent()) {
            return dojoOptional.get();
        } else {
            return null;
        }
    }

    public Dojo updateDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }

    public void deleteDojo(Long id) {
        dojoRepository.deleteById(id);
    }
}
