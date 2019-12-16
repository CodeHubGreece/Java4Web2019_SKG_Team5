package org.regeneration.team5.DoctorProject.repositories;

import org.regeneration.team5.DoctorProject.entities.Citizen;
import org.regeneration.team5.DoctorProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen,String> {
    Citizen findCitizenByAmka(String amka);
    Citizen findCitizenByEmail(String email);
    List<Citizen> findAll();
    Citizen findCitizenByUser(User user);
}
