package org.regeneration.team5.DoctorProject.service;

import org.regeneration.team5.DoctorProject.entities.Doctor;
import org.regeneration.team5.DoctorProject.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApiDoctorDetailsService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findDoctorsBySpeciality(int speciality){
        return doctorRepository.findDoctorBySpeciality(speciality);
    }

    public Doctor findDoctorById(int id){
        return doctorRepository.findByDoctorId(id);
    }
}
