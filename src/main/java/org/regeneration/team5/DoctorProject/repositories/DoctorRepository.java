package org.regeneration.team5.DoctorProject.repositories;

import org.regeneration.team5.DoctorProject.entities.Doctor;
import org.regeneration.team5.DoctorProject.entities.Speciality;
import org.regeneration.team5.DoctorProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    List<Doctor> findDoctorBySpeciality(Speciality speciality);
    Doctor findByDoctorId(int id);
    Doctor findByUser(User user);
}
