package com.lucker.user.config;

import com.lucker.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
    @Autowired
    private KafkaTemplate<String, User> simpleKafkaTemplate;
    public void send(String topic, User payload) {
        LOGGER.info("sendingoad='{}' to topic='{}'", payload, topic);
        simpleKafkaTemplate.send(topic, payload);
    }
}
