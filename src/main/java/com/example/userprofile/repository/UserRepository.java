package com.example.userprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userprofile.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{

}
