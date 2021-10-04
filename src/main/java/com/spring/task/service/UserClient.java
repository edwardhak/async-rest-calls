package com.spring.task.service;

import com.spring.task.exception.ApiException;
import com.spring.task.model.Post;
import com.spring.task.model.User;
import com.spring.task.model.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Slf4j
@Service
public class UserClient {

    private static final String GET_USER_URI = "/users/{userId}";
    private static final String GET_POSTS_URI = "/posts";

    private WebClient webClient;

    public UserClient(@Value("${services.url}") final String url) {
        this.webClient = WebClient.create(url);
    }

    public Flux<UserResponse> fetchUserAndPosts(final Long userId) {
        log.info("Calling fetchUserAndPosts by userId:{}", userId);

        final Mono<User> user = getUser(userId).subscribeOn(Schedulers.elastic());
        final Mono<List<Post>> items = getPosts(userId).subscribeOn(Schedulers.elastic());

        return Flux.zip(user, items, UserResponse::new);
    }

    private Mono<User> getUser(final Long userId) {
        return webClient.get()
                .uri(GET_USER_URI, userId)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response ->
                        Mono.error(new ApiException(response.statusCode(), response.toString()))
                )
                .onStatus(HttpStatus::is5xxServerError, response ->
                        Mono.error(new ApiException(response.statusCode(), response.toString()))
                )
                .bodyToMono(User.class);
    }

    private Mono<List<Post>> getPosts(final Long userId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path(GET_POSTS_URI)
                        .queryParam("userId", userId).build())
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response ->
                        Mono.error(new ApiException(response.statusCode(), response.toString()))
                )
                .onStatus(HttpStatus::is5xxServerError, response ->
                        Mono.error(new ApiException(response.statusCode(), response.toString()))
                )
                .bodyToFlux(Post.class).collectList();
    }
}
