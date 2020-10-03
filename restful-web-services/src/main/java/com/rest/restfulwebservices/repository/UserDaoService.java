package com.rest.restfulwebservices.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.rest.restfulwebservices.bean.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int userCount=3;
	static {
		users.add(new User("Sachin", 1, "Sachin", "Ghalme", new Date()));
		users.add(new User("Sachin", 2, "Sachin", "Ghalme", new Date()));
		users.add(new User("Sachin", 3, "Sachin", "Ghalme", new Date()));	
	}
	
	public List<User> findAll(){
		return users;
	}
	
	
	public User save(User user) {
		user.Id=++userCount;
		users.add(user);
		return user;
	}


	


	public User getUser(int id) {
		// TODO Auto-generated method stub
		Optional<User> resList= users.stream().filter(u->u.getId()==id).findFirst();
		return (!resList.isPresent()) ? null : resList.get() ;
	}
	
}
