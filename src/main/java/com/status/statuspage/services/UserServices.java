package com.status.statuspage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.status.statuspage.entity.Users;
import com.status.statuspage.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;
	
	public Users saveUser(Users user) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
		return userRepository.save(user);
	}
}
