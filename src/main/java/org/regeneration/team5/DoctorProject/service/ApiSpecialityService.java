package org.regeneration.team5.DoctorProject.service;

import org.regeneration.team5.DoctorProject.entities.Speciality;
import org.regeneration.team5.DoctorProject.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiSpecialityService {
    @Autowired
    private final SpecialityRepository specialityRepository;

    public ApiSpecialityService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    public List<Speciality> getListOfSpecialities(){
        return specialityRepository.findAll();
    }

    public Speciality findById(int id){
        return specialityRepository.findBySpecialityId(id);
    }

    public Speciality findSpecialitiesByTitle(String title){
        return specialityRepository.findSpecialitiesByTitle(title);
    }
}
