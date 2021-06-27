package com.henrry.overflow.services;

import com.henrry.overflow.repositories.BaseRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<T> {
    private final BaseRepository<T> repository;

    public BaseService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    public List<T> allData() {
        return repository.findAll();
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public T findById(Long id) {
        Optional<T> optionalT = repository.findById(id);
        if(optionalT.isPresent()) {
            return optionalT.get();
        } else {
            return null;
        }
    }

    public T update(T entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
