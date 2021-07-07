package com.henrry.waterbnb.repositories;

import com.henrry.waterbnb.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {
    User findByEmail(String email);
}
