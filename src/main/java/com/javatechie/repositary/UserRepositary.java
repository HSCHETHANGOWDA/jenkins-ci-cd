package com.javatechie.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.entity.User;

@Repository
public interface UserRepositary extends JpaRepository<User, Long>{

}
