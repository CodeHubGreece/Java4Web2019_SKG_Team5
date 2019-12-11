package org.regeneration.team5.DoctorProject.service;

import org.regeneration.team5.DoctorProject.entities.Citizen;
import org.regeneration.team5.DoctorProject.repositories.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ApiCitizenDetailsService {
    private CitizenRepository citizenRepository;

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
}
