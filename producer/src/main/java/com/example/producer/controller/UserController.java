package com.example.producer.controller;

import com.example.producer.payload.UserDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Value("${spring.rabbitmq.exchange}")
    private String EXCHANGE;

    @Value("${spring.rabbitmq.routingkey}")
    private String ROUTING_KEY;

    private final RabbitTemplate template;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/sendUser")
    public String receiveUser(@RequestBody UserDto userDto) {
        logger.info("Received Dto: " + userDto);
        template.convertAndSend(EXCHANGE, ROUTING_KEY, userDto);
        return "Sent user: " + userDto;
    }
}
