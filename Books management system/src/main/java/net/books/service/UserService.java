package net.books.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.books.controller.dto.UserRegistrationDto;
import net.books.entity.User;



public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}