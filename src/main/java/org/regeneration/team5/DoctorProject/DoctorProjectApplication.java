package org.regeneration.team5.DoctorProject;

import org.regeneration.team5.DoctorProject.entities.Citizen;
import org.regeneration.team5.DoctorProject.entities.User;
import org.regeneration.team5.DoctorProject.repositories.CitizenRepository;
import org.regeneration.team5.DoctorProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DoctorProjectApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(DoctorProjectApplication.class, args);
	}
	@Autowired
	public UserRepository userRepository;

	@Autowired
	public CitizenRepository citizenRepository;

	@Override
	public void run(String... args) throws Exception {
		User u = new User("nikolina","p","nikolinap","123456");
		/*
		Sign up
		 */
		Citizen c = new Citizen("123456","nikolp@hol.com","69999999",u);
		List<User> userList = User.getUserList();
		userList.add(u);
		if(u.getUserType()){
			List<Citizen> citizenList = Citizen.getCitizenList();
			citizenList.add(c);
			citizenRepository.saveAll(citizenList);
		}else {
			System.out.println("Doctor");
		}

		//User.setUserList(userList);
		//userRepository.saveAll(userList);
	}
}
