package com.esnuguel.cloud.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.esnuguel.cloud.CloudApplication;
import com.esnuguel.cloud.DTO.UserDTO;
import com.esnuguel.cloud.Models.User;
import com.esnuguel.cloud.Repository.UserRepository;
import com.google.cloud.Timestamp;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class GreetingController {

    private final UserRepository ur;
    public GreetingController(UserRepository ur) {
        this.ur = ur;
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Hola dios esnu!";
    }

    @GetMapping("/user")
    public Flux<User> getAllUser() {
        return ur.findAll();
    }

    @PostMapping("/user")
    public Mono<User> createUser(@RequestBody UserDTO userDTO) {
        return Mono.just(userDTO)
        .map(user -> User.builder()
                .username(user.username())
                .firstname(user.firstname())
                .lastname(user.lastname())
                .age(user.age())
                .email(user.email())
                .createdAt(Timestamp.now())
                .build())
        .flatMap(ur::save);
    }
    
    
}
