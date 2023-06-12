package com.jpa_spring.classes;

import org.springframework.data.repository.CrudRepository;
import com.jpa_spring.classes.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
}