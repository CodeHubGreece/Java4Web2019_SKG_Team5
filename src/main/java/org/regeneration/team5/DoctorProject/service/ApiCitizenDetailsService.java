package org.regeneration.team5.DoctorProject.service;

import org.regeneration.team5.DoctorProject.dto.Registration;
import org.regeneration.team5.DoctorProject.entities.Citizen;
import org.regeneration.team5.DoctorProject.entities.User;
import org.regeneration.team5.DoctorProject.repositories.CitizenRepository;
import org.regeneration.team5.DoctorProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;

@Service
public class ApiCitizenDetailsService {
    private CitizenRepository citizenRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ApiCitizenDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setCitizenRepository(CitizenRepository citizenRepository){
        this.citizenRepository = citizenRepository;
    }

    public Citizen loadCitizenByAmka(String amka){
        Citizen citizen = citizenRepository.findCitizenByAmka(amka);
        if (citizen == null){
            System.out.println("Not a citizen");
        }
        return citizenRepository.findCitizenByAmka(amka);
    }

    public Citizen setCitizen(Registration registration) throws InputMismatchException {
        try {
            User user = new User();
            user.setFirstname(registration.getFirstname());
            user.setLastname(registration.getLastname());
            user.setUsername(registration.getUsername());
            user.setPassword(passwordEncoder.encode(registration.getPassword()));
            userRepository.save(user);
            Citizen citizen = new Citizen();
            citizen.setAmka(registration.getAmka());
            citizen.setEmail(registration.getEmail());
            citizen.setMobile(registration.getMobile());
            citizen.setUser(user);
            citizenRepository.save(citizen);
            return citizen;
        }catch (InputMismatchException m){
            throw m;
        }

    }
}
