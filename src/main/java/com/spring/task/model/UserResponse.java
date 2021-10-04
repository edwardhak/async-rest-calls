package com.spring.task.model;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class UserResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2586288942876924232L;

    private List<Post> posts;

    private User user;

    public UserResponse(final User user, final List<Post> posts) {
        this.user = user;
        this.posts = posts;
    }

}
