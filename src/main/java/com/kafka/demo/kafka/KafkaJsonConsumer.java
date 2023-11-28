package com.kafka.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.demo.dto.User;

@Service
public class KafkaJsonConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);
	
	@KafkaListener(topics = "FirstJsonTopic", groupId = "group1")
	public void consumeJsonMessage(User user) {
		LOGGER.info(String.format("Message sent", user.toString()));

	}
}
