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
public class Company implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5719077657594924253L;

    private String name;
    private String catchPhrase;
    private String bs;
}
