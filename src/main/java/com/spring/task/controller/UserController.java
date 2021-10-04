package com.spring.task.controller;

import com.spring.task.model.UserResponse;
import com.spring.task.service.UserClient;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@Slf4j
@Api(value = "User information")
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserClient userClient;

    public UserController(final UserClient userClient) {
        this.userClient = userClient;
    }

    @ApiOperation(httpMethod = "GET", value = "Get all user information", response = Flux.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "The user information could not be fetched")
    })
    @GetMapping(value = "/{userId}")
    public Flux<ResponseEntity<UserResponse>> getAggregationInformation(@ApiParam(value = "userId", required = true) @PathVariable("userId") final Long userId) {
        log.info("getAggregationInformation by userId:{}", userId);

        return userClient.fetchUserAndPosts(userId).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
