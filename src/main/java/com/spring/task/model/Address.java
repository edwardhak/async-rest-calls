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
public class Address implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4749572183748282838L;

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
}
