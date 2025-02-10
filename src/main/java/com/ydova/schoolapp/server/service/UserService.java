package com.ydova.schoolapp.server.service;

import com.ydova.schoolapp.server.entity.User;
import com.ydova.schoolapp.server.repository.RepositoryFactory;
import com.ydova.schoolapp.server.repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;
    public UserService() {
        this.userRepository = RepositoryFactory.getInstance(UserRepository.class);
    }
    public void save (User entity) {
        userRepository.save(entity);

    }
    public User read(Long id) {
        return this.userRepository.read(id);
    }
    public List<User> readAll() {
        return this.userRepository.readAll();
    }
    public void update(User entity) {
        this.userRepository.update(entity);
    }
    public void delete(Long id) {
        this.userRepository.delete(id);
    }
}
