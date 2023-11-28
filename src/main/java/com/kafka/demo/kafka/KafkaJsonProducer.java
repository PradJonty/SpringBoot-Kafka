package com.kafka.demo.kafka;

import org.springframework.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafka.demo.dto.User;


@Service
public class KafkaJsonProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);
	
	private KafkaTemplate<String, User> kafkaTemplate;

	public KafkaJsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	
	public void sendMessage(User user) {
		LOGGER.info(String.format("Message sent", user.toString()));
		Message<User> message = MessageBuilder
				.withPayload(user)
				.setHeader(KafkaHeaders.TOPIC,"FirstJsonTopic")
				.build();
		kafkaTemplate.send(message);
		
	}
}