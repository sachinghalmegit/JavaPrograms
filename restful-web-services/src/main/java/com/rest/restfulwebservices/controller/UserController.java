package com.rest.restfulwebservices.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.restfulwebservices.bean.User;
import com.rest.restfulwebservices.exception.UserNotFoundException;
import com.rest.restfulwebservices.repository.UserDaoService;

import net.bytebuddy.asm.Advice.Local;

@RestController
public class UserController {

	@Autowired
	private MessageSource messageSoiurce;
	
	@Autowired
	private UserDaoService service;

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello Word";
	}

	@GetMapping("/Users")
	public List<User> getAllUsers() {
		return service.findAll();
	}

	@PostMapping("/user")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		user = service.save(user);
		
		URI location = ServletUriComponentsBuilder. 
				fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return (ResponseEntity<Object>) ResponseEntity.created(location).build();
		//return user;
	}

	@GetMapping("/Users/{id}")
	public User getUser(@PathVariable int id) throws UserNotFoundException {
		User user= service.getUser(id);
		if (user==null) {
			throw new UserNotFoundException("User Not Found");
		}
		return user;
	}
	
	@GetMapping("/Users/Greeting")
	public String greeting(@RequestHeader(name="accept-langualge",required=false)Locale local) {
		//return messageSoiurce.getMessage("goog.morning.message",null,local);
		
		return messageSoiurce.getMessage("goog.morning.message",null,LocaleContextHolder.getLocale());
		
	}
}
