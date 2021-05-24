package com.avaya.kafka.springbootkafkaexample.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaya.kafka.springbootkafkaexample.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource
{
	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;

	private static final String TOPIC = "message_topic1";


	@GetMapping("/publish/{message}")
	public String postMessage(@PathVariable("message")
	final String myMessage)
	{
		kafkaTemplate.send(TOPIC, new User(4, "RND", myMessage));
		return "Published Message  " + myMessage;
	}
}
