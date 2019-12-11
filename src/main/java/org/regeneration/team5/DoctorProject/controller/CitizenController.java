package org.regeneration.team5.DoctorProject.controller;

import org.regeneration.team5.DoctorProject.entities.Citizen;
import org.regeneration.team5.DoctorProject.entities.User;
import org.regeneration.team5.DoctorProject.repositories.CitizenRepository;
import org.regeneration.team5.DoctorProject.repositories.UserRepository;
import org.regeneration.team5.DoctorProject.service.ApiCitizenDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

public class CitizenController {

    private User user;
    private Citizen citizen;
    private ApiCitizenDetailsService apiCitizenDetailsService;
    private CitizenRepository citizenRepository;
    private UserRepository userRepository;

    @PostMapping(value = {"/register"})
    public void registerCitizen(User user,Citizen citizen){

        Citizen citizenExists = apiCitizenDetailsService.loadCitizenByAmka(citizen.getAmka());
        if(citizenExists==null){
            System.out.println("The user Exists");
        }
        else{
            citizenRepository.save(citizen);
            userRepository.save(user);
        }
    }
}
