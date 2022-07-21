package com.cts.authorizationmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authorizationmodule.model.AuthResponse;
import com.cts.authorizationmodule.model.UserModel;
import com.cts.authorizationmodule.service.JwtUtil;
import com.cts.authorizationmodule.service.MyUserDetailsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthController {

	@Autowired
	private JwtUtil jwtutil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserModel userlogincredentials) {
		log.info("Start {}", this.getClass().getSimpleName());
		final UserDetails userdetails = userDetailsService.loadUserByUsername(userlogincredentials.getId());
		String uid = "";
		String generateToken = "";
		if (userdetails.getPassword().equals(userlogincredentials.getPassword())) {
			uid = userlogincredentials.getId();
			generateToken = jwtutil.generateToken(userdetails);
			System.out.println("Jwt" + generateToken);
			log.info("End {}", this.getClass().getSimpleName());
			System.out.println("Jwt" + generateToken);
			return new ResponseEntity<>(new UserModel(uid, null, null, generateToken), HttpStatus.OK);
		} else {
			log.info("Not Accessible - End {} ", this.getClass().getSimpleName());
			return new ResponseEntity<>("Not Accesible", HttpStatus.FORBIDDEN);
		}
	}

	@GetMapping("/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token) {
		log.info("Start {}", this.getClass().getSimpleName());
		AuthResponse res = new AuthResponse();
		if (token == null) {
			res.setValid(false);
			log.info("Null Token - End {}", this.getClass().getSimpleName());
			return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
		} else {
			if (token.contains("Bearer")) {
				token = token.substring(7);
			}
			if (jwtutil.validateToken(token)) {
				res.setId(jwtutil.extractUsername(token));
				res.setValid(true);
				res.setName("Agent");
			} else {
				res.setValid(false);
				log.info("Invalid Token - End {} ", this.getClass().getSimpleName());
				return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);

			}
		}
		log.info(" Token accepted - End {}", this.getClass().getSimpleName());
		return new ResponseEntity<>(res, HttpStatus.OK);

	}
}
