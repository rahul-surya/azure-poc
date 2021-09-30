/*
 *  05-08-2021 
 *  Copyright (c) 2021 AST Corporation. All Rights Reserved.
 *
 *
 *
*/

package com.ast;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rsuryavanshi
 *
 */
@RestController
@Slf4j
@RequestMapping("/iam")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	    @PostMapping("/users")
	    public ResponseEntity<Object> createUser(@RequestBody User user) {
	    	
	    	log.info("user:"+user.getEmailId());
	    	
	        User savedUser =  userRepository.save(user);
	        
	        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	    			.buildAndExpand(savedUser.getId()).toUri();

	    	return ResponseEntity.created(location).build();
	    }
	    
	    @PutMapping("/users/{id}")
	    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id) {
	    	
	    	log.info("user:"+user.getEmailId());
	    	
	    	Optional<User> usrOpt = userRepository.findById(id);

	    	if (!usrOpt.isPresent())
	    		return ResponseEntity.notFound().build();

	    	user.setId(id);
	    	
	    	userRepository.save(user);

	    	return ResponseEntity.noContent().build();
	    	
	        
	    }
	    

}
