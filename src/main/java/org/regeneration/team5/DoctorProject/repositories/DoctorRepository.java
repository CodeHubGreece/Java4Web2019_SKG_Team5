package org.regeneration.team5.DoctorProject.repositories;

import org.regeneration.team5.DoctorProject.entities.Doctor;
import org.regeneration.team5.DoctorProject.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    List<Doctor> findDoctorBySpeciality(int specialityId);
    Doctor findByDoctorId(int id);
}
