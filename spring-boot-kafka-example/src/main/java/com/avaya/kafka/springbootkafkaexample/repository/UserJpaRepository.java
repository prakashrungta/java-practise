package com.avaya.kafka.springbootkafkaexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.avaya.kafka.springbootkafkaexample.model.User;

@Component
public interface UserJpaRepository extends JpaRepository<User, Long>
{
	User findByName(String name);
}
