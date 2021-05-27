package com.avaya.kafka.springbootkafkaexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaya.kafka.springbootkafkaexample.model.User;

@RestController
@RequestMapping("kafka")
public class KafkaProducerController {
	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;

	private static final String TOPIC = "message_topic1";

	@GetMapping("/publish/{message}")
	public String postMessage(@PathVariable final Integer myMessage) {
		// kafkaTemplate.send(TOPIC, new User(4L, "PrakashRungta", "CC-DEV",
		// myMessage));
		return "Published Message  " + myMessage;
	}

	@PostMapping("/publish/message")
	public User postMessage(@RequestBody User myMessage) {
		User user = new User(myMessage.getId(), myMessage.getName(), myMessage.getDepartment(), myMessage.getSalary());

		return myMessage;
	}

	@PostMapping("/publish/messageswithresponse")
	public ResponseEntity<User> postMessages(@RequestBody User myMessage) {
		User user = new User(myMessage.getId(), myMessage.getName(), myMessage.getDepartment(), myMessage.getSalary());

		return new ResponseEntity<>(user, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);

	}
}
