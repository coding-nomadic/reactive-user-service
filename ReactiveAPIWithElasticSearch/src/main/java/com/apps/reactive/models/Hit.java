package com.apps.reactive.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hit {
    private String _index;
    private String _type;
    private String _id;
    private Double _score;
    private User _source;
}
