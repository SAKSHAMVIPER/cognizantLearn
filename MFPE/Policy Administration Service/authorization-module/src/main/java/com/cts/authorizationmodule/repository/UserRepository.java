package com.cts.authorizationmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.authorizationmodule.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
