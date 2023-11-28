package com.kafka.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
	
	public NewTopic kafkaFirstTopic() {
		return TopicBuilder
				.name("FirstTopic")
				.build();				
	}
	
	public NewTopic kafkaJsonFirstTopic() {
		return TopicBuilder
				.name("FirstJsonTopic")
				.build();
	}
}
