package org.regeneration.team5.DoctorProject.controller;

import org.regeneration.team5.DoctorProject.entities.Speciality;
import org.regeneration.team5.DoctorProject.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecialityController {
    private final SpecialityRepository specialityRepository;

    public SpecialityController(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @GetMapping("/api/specialties")
    public List<Speciality> findAll(){
        return specialityRepository.findAll();
    }
}
