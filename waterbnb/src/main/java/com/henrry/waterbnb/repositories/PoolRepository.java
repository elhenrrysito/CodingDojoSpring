package com.henrry.waterbnb.repositories;

import java.util.List;

import com.henrry.waterbnb.models.Pool;

import org.springframework.stereotype.Repository;

@Repository
public interface PoolRepository extends BaseRepository<Pool> {
    List<Pool> findByAddressContaining(String address);
}