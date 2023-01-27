package com.apps.reactive.clients;

import com.apps.reactive.config.AppConfig;
import com.apps.reactive.exceptions.UserException;
import com.apps.reactive.models.User;
import com.apps.reactive.utils.JsonUtils;
import com.apps.reactive.utils.ResponseBuilderUtils;
import com.apps.reactive.utils.UrlBuilderUtils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
/**
 * 
 * @author Tenzin Dawa
 *
 */
public class ElasticSearchClient {
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private WebClient.Builder webClientBuilder;
    private static final Logger LOGGER = Logger.getLogger(ElasticSearchClient.class);

    /**
     * 
     * @param user
     * @return
     * @throws IOException
     */
    public Mono<Void> insertUserData(User user) {
        final String postUrl = UrlBuilderUtils.url(appConfig, user.getUserId());
        return webClientBuilder.build().post().uri(postUrl)
                                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                        .body(Mono.just(JsonUtils.toString(user)), String.class).retrieve()
                                        .onStatus(HttpStatus::isError, response -> {
                                            LOGGER.error(String.format("Error calling Elastic API to insert due to : %s",
                                                                            response.statusCode()));
                                            return Mono.error(new UserException(response.toString(), "102"));
                                        }).bodyToMono(Void.class);
    }

    /**
     * 
     * @param user
     * @return
     * @throws IOException
     */
    public Mono<Void> updateUserData(User user) {
        final String updateUrl = UrlBuilderUtils.url(appConfig, user.getUserId());
        return webClientBuilder.build().put().uri(updateUrl)
                                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                        .body(Mono.just(JsonUtils.toString(user)), String.class).retrieve()
                                        .onStatus(HttpStatus::isError, response -> {
                                            LOGGER.error(String.format("Error calling Elastic API to update due to : %s",
                                                                            response.statusCode()));
                                            return Mono.error(new UserException(response.toString(), "102"));
                                        }).bodyToMono(Void.class);
    }

    /**
     * 
     * @param user
     * @return
     * @throws IOException
     */
    public Mono<User> getUserData(String id) {
        final String updateUrl = UrlBuilderUtils.url(appConfig, id);
        return webClientBuilder.build().get().uri(updateUrl)
                                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).retrieve()
                                        .onStatus(HttpStatus::isError, response -> {
                                            LOGGER.error(String.format("Error calling Elastic API to fetch due to : %s",
                                                                            response.statusCode()));
                                            return Mono.error(new UserException(response.toString(), "102"));
                                        }).bodyToMono(Object.class)
                                        .flatMap(response -> Mono.just(ResponseBuilderUtils.prepare(response)));
    }

    /**
     * 
     * @return
     */
    public Flux<List<User>> getAllUserData() {
        final String getAllUrl = UrlBuilderUtils.getAllUrl(appConfig);
        return webClientBuilder.build().get().uri(getAllUrl)
                                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).retrieve()
                                        .onStatus(HttpStatus::isError, response -> {
                                            LOGGER.error(String.format("Error calling Elastic API to getAll due to : %s",
                                                                            response.statusCode()));
                                            return Mono.error(new UserException(response.toString(), "102"));
                                        }).bodyToFlux(Object.class)
                                        .flatMap(response -> Mono.just(ResponseBuilderUtils.prepareList(response)));
    }
}
