package org.regeneration.team5.DoctorProject.controller;

import org.apache.tomcat.util.buf.UDecoder;
import org.regeneration.team5.DoctorProject.entities.Speciality;
import org.regeneration.team5.DoctorProject.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecialityController {
    private final SpecialityRepository specialityRepository;

    public SpecialityController(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @GetMapping("/getspecialities")
    public List<Speciality> findAll(){
        return specialityRepository.findAll();
    }

    @GetMapping("/getspeciality/{id}")
    public Speciality findSpecialityById(@PathVariable int id){
        return specialityRepository.findBySpecialityId(id);
    }

    @GetMapping("/getspeciality/{title}")
    public Speciality findSpecialityByTitle(@PathVariable String title){
        String decoded = UDecoder.URLDecode(title);
        System.out.println(title);
        return specialityRepository.findSpecialitiesByTitle(decoded);
    }



}
