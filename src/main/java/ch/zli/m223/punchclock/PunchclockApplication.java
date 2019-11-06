package ch.zli.m223.punchclock;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class PunchclockApplication {

	//Means similar function was allready commented in other class or is unecessary to describe.e
	//..

	static ApplicationUserRepository applicationUserRepository;

	public PunchclockApplication(ApplicationUserRepository applicationUserRepository) {
		this.applicationUserRepository = applicationUserRepository;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		//Script to generate Users on Application start
		SpringApplication.run(PunchclockApplication.class, args);
		ApplicationUser user1 = new ApplicationUser("Nils", "Chapman");
		ApplicationUser user2 = new ApplicationUser("Max", "Muster");
		ApplicationUser user3 = new ApplicationUser("Hans", "Müller");

		ArrayList<ApplicationUser> users = new ArrayList<ApplicationUser>();
			users.add(user1);
			users.add(user2);
			users.add(user3);

		applicationUserRepository.saveAll(users);
	}

}
