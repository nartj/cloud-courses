package com.utbm.lo54.clientwebapp;

import com.utbm.lo54.security.domain.Role;
import com.utbm.lo54.security.repository.RoleRepository;
import com.utbm.lo54.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientWebappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClientWebappApplication.class, args);
	}

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		//testApp.performDbTasks();
		Role roleAdmin = new Role(1L, "ROLE_ADMIN");
		Role roleUser = new Role(2L, "ROLE_USER");
		roleRepository.save(roleAdmin);
		roleRepository.save(roleUser);
//		Set<Role> adminAuthorities = new HashSet<>(Arrays.asList(roleAdmin, roleUser));
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		userRepository.save(new User(1L,
//				"admin",
//				encoder.encode("admin"),
//				true,
//				null,
//				adminAuthorities));
//		userRepository.save(new User(2L,
//				"user",
//				encoder.encode("user"),
//				true,
//				null,
//				new HashSet<>(Collections.singletonList(roleUser))));

	}
}
