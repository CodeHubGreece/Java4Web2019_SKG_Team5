package org.regeneration.team5.DoctorProject;

import org.regeneration.team5.DoctorProject.entities.Citizen;
import org.regeneration.team5.DoctorProject.entities.User;
import org.regeneration.team5.DoctorProject.repositories.CitizenRepository;
import org.regeneration.team5.DoctorProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DoctorProjectApplication {


	public static void main(String[] args) {
		SpringApplication.run(DoctorProjectApplication.class, args);
	}

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public CitizenRepository citizenRepository;




		//User.setUserList(userList);
		//userRepository.saveAll(userList);


}
