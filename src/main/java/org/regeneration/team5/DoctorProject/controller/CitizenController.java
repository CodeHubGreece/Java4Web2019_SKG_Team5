package org.regeneration.team5.DoctorProject.controller;

import org.regeneration.team5.DoctorProject.dto.Registration;
import org.regeneration.team5.DoctorProject.entities.Citizen;
import org.regeneration.team5.DoctorProject.repositories.CitizenRepository;
import org.regeneration.team5.DoctorProject.repositories.UserRepository;
import org.regeneration.team5.DoctorProject.service.ApiCitizenDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CitizenController {

    private final ApiCitizenDetailsService apiCitizenDetailsService;
    private final UserRepository userRepository;
    private final CitizenRepository citizenRepository;


    public CitizenController(ApiCitizenDetailsService apiCitizenDetailsService, UserRepository userRepository, CitizenRepository citizenRepository) {
        this.apiCitizenDetailsService = apiCitizenDetailsService;
        this.userRepository = userRepository;
        this.citizenRepository = citizenRepository;
    }

    @PostMapping(value = "/register")
    public Citizen registerCitizen(@RequestBody Registration registration){
        //if(userRepository.findByUsername(registration.getUsername())==null && citizenRepository.findCitizenByAmka(registration.getAmka())==null){
            return apiCitizenDetailsService.setCitizen(registration);
        //}else{
        //    System.out.println("User already exists");
        //}
    }
}
