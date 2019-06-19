package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.hateoas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.model.User;
import com.in28minutes.rest.webservices.restfulwebservices.service.UserDaoService;

@RestController
public class UserResource {
	@Autowired
	UserDaoService userDaoService;

	@GetMapping("/users")
	public List<User> retreiveAllUsers(){
		return userDaoService.findAll();
	}
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		
		User user= userDaoService.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
	
		//"all-users",SERVER_PATH + "/users"
		//retreiveAllUsers
	    //Resource<User> resource=new Resource<User>(user);
	    //HATEOAS
		
		return user;
	}
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser=userDaoService.save(user);

		URI location =ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{id}")
				.buildAndExpand(savedUser.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		User user=userDaoService.deleteById(id);
		
		if(user==null)
			throw new UserNotFoundException("id-"+id);

		URI location =ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{id}")
				.buildAndExpand(user.getId()).toUri();

		return ResponseEntity.noContent().build();
	}
}
