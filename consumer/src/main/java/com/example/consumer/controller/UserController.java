package com.example.consumer.controller;


import com.example.consumer.entity.User;
import com.example.consumer.payload.UserDto;
import com.example.consumer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @RabbitListener(queues = {"${spring.rabbitmq.queue}"})
    public void saveUser(@RequestBody UserDto userDto) {
        logger.info("Handled message: " + userDto);
        userRepository.save(new User(userDto.getUsername()));
    }
}
