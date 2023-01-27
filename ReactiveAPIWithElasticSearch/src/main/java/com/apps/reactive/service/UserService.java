package com.apps.reactive.service;

import com.apps.reactive.models.User;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Tenzin Dawa
 *
 */
public interface UserService {
    /**
     * 
     * @param user
     */
    public Mono<Void> addUser(User user);

    /**
     * 
     * @param user
     */
    public Mono<Void> updateUser(User user);

    /**
     * 
     * @param user
     * @return
     */
    public Mono<User> getUserById(String id);

    /**
     * 
     * @param user
     */
    public Flux<List<User>> getAllUsers();
}
