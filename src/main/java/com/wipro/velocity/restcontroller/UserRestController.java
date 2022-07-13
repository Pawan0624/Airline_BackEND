package com.wipro.velocity.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.velocity.model.User;
import com.wipro.velocity.repository.UserRepository;

@RestController
@RequestMapping("/Airline")
@CrossOrigin(origins="*")
public class UserRestController {

	@Autowired
	private UserRepository urepo;
	
	@PostMapping("/users")
	public Boolean loginUser(@Validated @RequestBody User user) {
		Boolean a = false;
		String email = user.getEmail();
		String password = user.getPassword();
		User d = urepo.findByemail(email);

		if (email.equals(d.getEmail()) && password.equals(d.getPassword())) {
			a = true;
		}
		return a;
	}
	
	@PostMapping("/admin")
	public Boolean loginAdmin(@Validated @RequestBody User user) {
		Boolean b = false;
		String email = user.getEmail();
		String password = user.getPassword();
		//User d = urepo.findByEmail(email);

		if (email.equals("pawankalyanpr@gmail.com") && password.equals("9505357949")) {
			b = true;
		}
		return b;
	}
	
	@PostMapping("/user")
	public User createUser(@Validated @RequestBody User user)
	{
		System.out.println("In Rest");
		User d = new User();
		d.setEmail(user.getEmail());
		d.setfname(user.getfname());
		d.setlname(user.getlname());
		d.setPassword(user.getPassword());
		d.setDob(user.getDob());
		d.setPhn(user.getPhn());
		urepo.save(d);
		return user;
	}

	@GetMapping("/user")
	public List<User> getAllUser(){
		return urepo.findAll();
	}
}
