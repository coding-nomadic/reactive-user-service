package com.apps.reactive.service;

import com.apps.reactive.clients.ElasticSearchClient;
import com.apps.reactive.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import reactor.core.publisher.Mono;

@Service
/**
 * 
 * @author Tenzin Dawa
 *
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private ElasticSearchClient elasticSearchClient;

    @Override
    public Mono<Void> addUser(User user) {
        return elasticSearchClient.insertUserData(user);
    }

    @Override
    public Mono<Void> updateUser(User user) {
        return elasticSearchClient.updateUserData(user);
    }

    @Override
    public Mono<User> getUserById(String id) {
        return elasticSearchClient.getUserData(id);
    }

    @Override
    public Mono<List<User>> getAllUsers() {
        return elasticSearchClient.getAllUserData();
    }
}
