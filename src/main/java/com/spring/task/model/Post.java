package com.spring.task.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2003822257575396002L;

    private Long userId;
    private Long id;
    private String title;
    private String body;
}
