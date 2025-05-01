package com.raj.breezely.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.raj.breezely.entity.Users;
import com.raj.breezely.repository.UserRepository;
import com.raj.breezely.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean create(Users users) {
        try {
            if (users.getName() == null || users.getName().isEmpty()) {
                throw new IllegalArgumentException("User name can't be null or empty");
            }

            if (users.getEmail() == null || users.getEmail().isEmpty()) {
                throw new IllegalArgumentException("Email can't be null or empty");
            }

            if (users.getPassword() == null || users.getPassword().isEmpty()) {
                throw new IllegalArgumentException("Password can't be null or empty");
            }

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            Users newUser = Users.builder()
                    .name(users.getName())
                    .email(users.getEmail())
                    .userName(users.getUserName())
                    .password(passwordEncoder.encode(users.getPassword()))
                    .isActive(true)
                    .creationTime(LocalDateTime.now())
                    .build();

            userRepository.save(newUser);
            return true;

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Users update(ObjectId objectId, JsonNode requestBody) {
        Users user = userRepository.findById(objectId)
                .filter(Users::getIsActive)
                .orElse(null);

        if (user == null) {
            return null;
        }

        String name = requestBody.path("name").asText(null);
        String email = requestBody.path("email").asText(null);

        boolean changed = false;

        if (name != null && !name.equals(user.getName())) {
            user.setName(name);
            changed = true;
        }

        if (email != null && !email.equals(user.getEmail())) {
            user.setEmail(email);
            changed = true;
        }

        if (changed) {
            userRepository.save(user);
        }

        return user;
    }

    @Override
    public void delete(ObjectId objectId) {
        Users user = userRepository.findById(objectId)
                .filter(Users::getIsActive)
                .orElse(null);

        if (user != null) {
            userRepository.delete(user);
        }
    }


}
