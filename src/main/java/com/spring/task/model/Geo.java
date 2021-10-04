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
public class Geo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5570343950352977447L;

    private Double lat;
    private Double lng;
}
