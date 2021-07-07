package com.henrry.waterbnb.services;

import com.henrry.waterbnb.models.User;
import com.henrry.waterbnb.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends BaseService<User> {
    private final UserRepository userRepository;

    public UserService(UserRepository repositorioBase) {
        super(repositorioBase);
        this.userRepository = repositorioBase;
    }

    // register
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }

    //login (autenticar usuario)
    public boolean authenticateUser(String email, String password) {
        // encontramos user por email
        User user = userRepository.findByEmail(email);
        // si no lo encuentra retorna false
        if(user == null) {
            return false;
        } else {
            // si el password coincide devolvemos true sino false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
