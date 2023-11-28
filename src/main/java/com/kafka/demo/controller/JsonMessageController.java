package com.kafka.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.demo.dto.User;
import com.kafka.demo.kafka.KafkaJsonProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	@Autowired
	private KafkaJsonProducer kafkaJsonProducer;
	
	@PostMapping("/publish")
	public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
		kafkaJsonProducer.sendMessage(user);
		return ResponseEntity.ok("Json Message Successfully sent to the Kafka Topic");
		
		
	}
}
