package org.regeneration.team5.DoctorProject.repositories;

import org.regeneration.team5.DoctorProject.entities.Doctor;
import org.regeneration.team5.DoctorProject.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialityRepository extends JpaRepository<Speciality,Integer> {
    List<Speciality> findAll();
    Speciality findBySpecialityId(int id);
    Speciality findSpecialitiesByTitle(String title);
}
