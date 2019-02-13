package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import repo.UserRepo;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		userRepo.save(user);
		return user;
	}
	
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User user, @PathVariable long id) {
		for(User u:userRepo.findAll()) {
			if(u.getUserId()==user.getUserId()) {
				userRepo.save(user);
			}
		}
		return user;
	}
	
	@DeleteMapping("/user/{id}")
	public User deleteUser(@PathVariable long id, User user) {
		userRepo.delete(user);
		return user;
	}

}
