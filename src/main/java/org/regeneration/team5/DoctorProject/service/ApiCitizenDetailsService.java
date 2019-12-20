package org.regeneration.team5.DoctorProject.service;

import org.regeneration.team5.DoctorProject.dto.RegistrationDTO;
import org.regeneration.team5.DoctorProject.entities.Citizen;
import org.regeneration.team5.DoctorProject.entities.User;
import org.regeneration.team5.DoctorProject.repositories.CitizenRepository;
import org.regeneration.team5.DoctorProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;

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

    public Citizen findCitizenByEmail(String email){
        return citizenRepository.findCitizenByEmail(email);
    }

    public Citizen findCitizenByAmka(String amka){
        return citizenRepository.findCitizenByAmka(amka);
    }

    public List<Citizen> findAll(){
        return citizenRepository.findAll();
    }
    public Citizen findCitizenByUser(User user){
        return citizenRepository.findCitizenByUser(user);
    }

    public Citizen setCitizen(RegistrationDTO registrationDTO) throws InputMismatchException {
        try {
            User user = new User();
            user.setFirstname(registrationDTO.getFirstname());
            user.setLastname(registrationDTO.getLastname());
            user.setUsername(registrationDTO.getUsername());
            user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
            user.setRole("CITIZEN");
            userRepository.save(user);
            Citizen citizen = new Citizen();
            citizen.setAmka(registrationDTO.getAmka());
            citizen.setEmail(registrationDTO.getEmail());
            citizen.setMobile(registrationDTO.getMobile());
            citizen.setUser(user);
            citizenRepository.save(citizen);
            return citizen;
        }catch (InputMismatchException m){
            throw m;
        }
    }
}
