package com.eval.coronakit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.RolesRepository;
import com.eval.coronakit.dao.UserRepository;
import com.eval.coronakit.entity.Roles;
import com.eval.coronakit.entity.User;
import com.eval.coronakit.model.UserDetails;

@Service
public class CustomSecureService implements ISecureService {

	// dependency
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Override
	public boolean register(UserDetails userDetails) {
		// TODO Auto-generated method stub
		// divide userDetails object into User and Role Object
		/******** USER **********/
		User user = new User();
		user.setUsername(userDetails.getUserName());
		user.setPassword("{noop}" + userDetails.getPassword());
		// user.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(userDetails.getPassword()));;
		user.setEmail(userDetails.getEmail());
		user.setContact(userDetails.getContact());
		user.setEnabled(true);
		
		/********* Roles ************/
		
		for(String roleName : userDetails.getRoles()) {
			Roles role = new Roles();
			role.setUsername(userDetails.getUserName());
			role.setRole("ROLE_" + roleName);
			this.rolesRepository.save(role);
			
		}
		
		this.userRepository.save(user);
		
		return true;
	}

}
