package org.regeneration.team5.DoctorProject.controller;

import org.regeneration.team5.DoctorProject.dto.RegistrationDTO;
import org.regeneration.team5.DoctorProject.entities.Citizen;
import org.regeneration.team5.DoctorProject.repositories.CitizenRepository;
import org.regeneration.team5.DoctorProject.repositories.DoctorRepository;
import org.regeneration.team5.DoctorProject.repositories.SpecialityRepository;
import org.regeneration.team5.DoctorProject.repositories.UserRepository;
import org.regeneration.team5.DoctorProject.service.ApiCitizenDetailsService;
import org.regeneration.team5.DoctorProject.service.ApiSpecialityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CitizenController {

    private final ApiCitizenDetailsService apiCitizenDetailsService;
    private final UserRepository userRepository;
    private final CitizenRepository citizenRepository;
    private final DoctorRepository doctorRepository;
    private final SpecialityRepository specialityRepository;
    private final ApiSpecialityService apiSpecialityService;


    public CitizenController(ApiCitizenDetailsService apiCitizenDetailsService, UserRepository userRepository, CitizenRepository citizenRepository, DoctorRepository doctorRepository, SpecialityRepository specialityRepository, ApiSpecialityService apiSpecialityService) {
        this.apiCitizenDetailsService = apiCitizenDetailsService;
        this.userRepository = userRepository;
        this.citizenRepository = citizenRepository;
        this.doctorRepository = doctorRepository;
        this.specialityRepository = specialityRepository;
        this.apiSpecialityService = apiSpecialityService;
    }


    @PostMapping(value = "/register")
    public Citizen registerCitizen(@RequestBody RegistrationDTO registrationDTO){
         return apiCitizenDetailsService.setCitizen(registrationDTO);
    }

    @GetMapping("/citizens")
    public List<Citizen> findAll() {
        return apiCitizenDetailsService.findAll();
    }

}
