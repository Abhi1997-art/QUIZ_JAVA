package com.exam;

import com.exam.Service.UserService;
import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserviceApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {

		SpringApplication.run(ExamserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		System.out.println("Starting code");
/*
		User user = new User();
		user.setFirstname("Tannu");
		user.setLastname("Singh");
		user.setUsername("Tannu");
		user.setPassword("ta12");
		user.setEmail("Tannu@gmail.com");
		user.setPhone("98715379");
		user.setProfile("default.png");

		Role role = new Role();
		role.setId(24L);
		role.setRoleName("ADMIN");

		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);

		userRoleSet.add(userRole);

		User user1= this.userService.createUser(user,userRoleSet);
		System.out.println(user1.getUsername());*/



	}

}
