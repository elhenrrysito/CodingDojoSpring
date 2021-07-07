package com.henrry.waterbnb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T> extends CrudRepository<T, Long> {
    List<T> findAll();
}
