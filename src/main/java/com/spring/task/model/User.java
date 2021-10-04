package com.spring.task.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5562856185526650218L;

    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String webSite;
    private Company company;
    private Address address;

}
