package com.apps.reactive.controller;

import com.apps.reactive.models.User;
import com.apps.reactive.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
/**
 * 
 * @author Tenzin Dawa
 *
 */
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 
     * @param user
     * @return
     * @throws IOException
     */
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> saveUserData(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * 
     * @param user
     * @return
     * @throws IOException
     */
    @PutMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> updateUserData(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * 
     * @param user
     * @return
     * @throws IOException
     */
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<User> getUserData(@PathVariable String id) {
        return userService.getUserById(id);
    }

    /**
     * 
     * @return
     */
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public Flux<List<User>> getUserData() {
        return userService.getAllUsers();
    }
}
