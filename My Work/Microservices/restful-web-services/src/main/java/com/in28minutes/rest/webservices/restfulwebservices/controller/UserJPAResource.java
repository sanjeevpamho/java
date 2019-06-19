package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import com.in28minutes.rest.webservices.restfulwebservices.model.Post;
import com.in28minutes.rest.webservices.restfulwebservices.model.User;
import com.in28minutes.rest.webservices.restfulwebservices.service.UserDaoService;
import com.in28minutes.rest.webservices.restfulwebservices.userRepository.PostRepository;
import com.in28minutes.rest.webservices.restfulwebservices.userRepository.UserRepository;

@RestController
public class UserJPAResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping("/jpa/users")
	public List<User> retreiveAllUsers(){
		return userRepository.findAll();
	}
	@GetMapping("/jpa/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		
		Optional<User> user= userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
	
		//"all-users",SERVER_PATH + "/users"
		//retreiveAllUsers
	    //Resource<User> resource=new Resource<User>(user);
	    //HATEOAS
		
		return user.get();
	}
	@RequestMapping(method=RequestMethod.POST,value="/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser=userRepository.save(user);

		URI location =ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{id}")
				.buildAndExpand(savedUser.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retreiveAllPostForAUser(@PathVariable int id){
		Optional<User> userOptional= userRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		return userOptional.get().getPosts();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostsForAUser(@PathVariable int id ,
			                                         @RequestBody Post post) {
	
		Optional<User> userOptional= userRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		User user=userOptional.get();
		
		post.setUser(user);
		postRepository.save(post);

		URI location =ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{id}")
				.buildAndExpand(post.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
}
