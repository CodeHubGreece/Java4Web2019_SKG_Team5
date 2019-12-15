package org.regeneration.team5.DoctorProject.controller;

import org.regeneration.team5.DoctorProject.entities.User;
import org.regeneration.team5.DoctorProject.service.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class UserController {

    private final ApiUserService userService;

    public UserController(@Autowired ApiUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll(@RequestBody User user){
        return userService.findAll();
    }

    @GetMapping("/user")
    public User findByUsername(Principal principal){
        return userService.findByUsername(principal.getName());
    }
}
