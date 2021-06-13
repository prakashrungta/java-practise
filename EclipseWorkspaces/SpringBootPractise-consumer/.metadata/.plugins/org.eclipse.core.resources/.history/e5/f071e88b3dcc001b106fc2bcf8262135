package com.avaya.kafka.springbootkafkaexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaya.kafka.springbootkafkaexample.model.User;
import com.avaya.kafka.springbootkafkaexample.repository.UserJpaRepository;

@RestController
@RequestMapping("users")
public class UserController
{
	@Autowired
	UserJpaRepository userJpaRepository;

	@GetMapping("/all")
	public List<User> findAll()
	{
		System.out.println("*****Called /all ");
		return userJpaRepository.findAll();
	}


	@GetMapping("/{name}")
	public User findbyName(@PathVariable
	final String name)
	{
		return userJpaRepository.findByName(name);
	}


	@PostMapping("/load")
	public User load(@RequestBody
	final User user)
	{
		userJpaRepository.save(user);
		return userJpaRepository.findByName(user.getName());
	}
}
