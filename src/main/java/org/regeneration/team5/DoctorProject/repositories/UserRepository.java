package org.regeneration.team5.DoctorProject.repositories;
import org.regeneration.team5.DoctorProject.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUsername(String username);
    User findByUserID(int id);
    List<User> findByRole(String role);
}
