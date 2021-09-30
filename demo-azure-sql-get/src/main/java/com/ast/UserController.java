/*
 *  05-08-2021 
 *  Copyright (c) 2021 AST Corporation. All Rights Reserved.
 *
 *
 *
*/

package com.ast;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rsuryavanshi
 *
 */
@RestController
@Slf4j
@RequestMapping(value = "/iam")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	   
	    @GetMapping("/users")
	    public List<User> findAll() {
	    	
	    	log.info("finding all....");
	    	
	    	return userRepository.findAll();
			
			
	    }
	    
	    @GetMapping("/users/{id}")
	    public User findById(@PathVariable long id) {
	    	Optional<User> userOpt = userRepository.findById(id);

	    	if (!userOpt.isPresent())
	    		throw new StudentNotFoundException("id-" + id);

	    	return userOpt.get();
	    }

}
