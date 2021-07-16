package ch.twaenny.bookshelf.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.twaenny.bookshelf.model.AppUser;
import ch.twaenny.bookshelf.service.UserService;



@RestController()
@RequestMapping("rest/v1/users")
public class UserController {
	@Autowired
	private UserService userService;
		
	// returns all users
	@GetMapping("")
	List<UserDto> getAllUsers() {
		return userService.getAllUsers()
			.stream()
			.map(user -> new UserDto(user))
			.collect(Collectors.toList());
	}
	
	// returns new user
	@PostMapping("")
	UserDto insertUser(@RequestBody  UserInputDto userInput) {
		return new UserDto(
				userService.addUser(
						userInput.userName, 
						userInput.password, 
						userInput.roles)
			);
	}
	// finds a user by ID
	@GetMapping("/{id}")
	UserDto getUserById(@PathVariable("id") long userId) {
		return new UserDto(userService.getUserById(userId));
	}
	// deletes user by ID
	@DeleteMapping("/{id}")
	void deleteUserById(@PathVariable("id") long userId) {
		userService.deleteUserById(userId);
	}
	// sets existing user role
	@PutMapping("/{id}/roles")
	UserDto setRoles(@PathVariable("id") long id, @RequestBody RoleInputDto roles) {
		AppUser user = userService.setRolesForUser(id, roles.roles);
		return new UserDto(user);
	}
}
