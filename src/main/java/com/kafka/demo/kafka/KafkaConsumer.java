package com.kafka.demo.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
 
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private KafkaTemplate<String, String> kafkaTemplate;
    
    public KafkaConsumer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	
	@KafkaListener(topics = "FirstTopic", groupId = "group1")
	public void listen(String message) {
		LOGGER.info(String.format("Message succesfully recieved %s", message));
		kafkaTemplate.send("FirstTopic",message);
	}
}
