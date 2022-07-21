package com.cts.authorizationmodule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="users")
public class UserModel {
	
	@Id
	@Column(name = "userId")
	private String id;
	
	@Column(name = "userName")
	private String name;
	
	@Column(name = "userPassword")
	private String password;
	

	private String authToken;
}
