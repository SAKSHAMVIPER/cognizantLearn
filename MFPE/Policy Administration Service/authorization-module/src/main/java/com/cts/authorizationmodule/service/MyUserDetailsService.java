package com.cts.authorizationmodule.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.authorizationmodule.model.UserModel;
import com.cts.authorizationmodule.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user=userRepository.findById(username).orElse(null);
		if(user!=null) {
			log.info("{}, Information: Successfully Authenticated user", this.getClass().getSimpleName());
			return new User(user.getId(), user.getPassword(), new ArrayList<>());
		}
		else {
			log.debug("{}, Information: Throwing UsernameNotFoundException with message 'UsernameNotFoundException'",
                    this.getClass().getSimpleName());
			throw new UsernameNotFoundException("UsernameNotFoundException");
		}
	}

}
