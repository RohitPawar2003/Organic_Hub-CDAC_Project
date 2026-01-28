package com.cdac.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.modelmvc.User;
import com.cdac.repository.UserRepository;
import com.cdac.services.UserServices;

@Service
public class UserServicesImpl implements UserServices{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User registerUser(User user) {
		if(userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
}
