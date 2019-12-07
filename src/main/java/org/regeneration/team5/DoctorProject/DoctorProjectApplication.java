package org.regeneration.team5.DoctorProject;

import org.regeneration.team5.DoctorProject.entities.User;
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

	@Override
	public void run(String... args) throws Exception {
		List<User> userList = User.getUserList();
		userList.add(new User("ijhouho",",bcxvkjxbc","qp8euroet","knzclvjzc"));
		User.setUserList(userList);
		userRepository.saveAll(userList);
	}
}
