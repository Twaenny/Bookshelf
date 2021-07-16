package ch.twaenny.bookshelf.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.twaenny.bookshelf.repository.UserRepository;
import ch.twaenny.bookshelf.role.AppRoles;

@Component
public class Initializer implements ApplicationRunner {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<String> admin = new ArrayList<>();
		admin.add(AppRoles.admin);
		userRepository.insertUser("admin", "admin", admin, null, null);
		
		List<String> user = new ArrayList<>();
		user.add(AppRoles.user);
		userRepository.insertUser("user", "user", user, null, null);
		
		List<String> usemin = new ArrayList<>();
		usemin.add(AppRoles.user);
		usemin.add(AppRoles.admin);
		userRepository.insertUser("usmin", "usemin",usemin, null, null);
	}

}
