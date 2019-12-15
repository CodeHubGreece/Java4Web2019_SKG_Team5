package org.regeneration.team5.DoctorProject.service;

import org.regeneration.team5.DoctorProject.entities.User;
import org.regeneration.team5.DoctorProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiUserService {
    private final UserRepository userRepository;

    public ApiUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findByUserId(int id){
        return userRepository.findByUserID(id);
    }

    public List<User> findByUserType(String type){
        return userRepository.findByUserType(type);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
