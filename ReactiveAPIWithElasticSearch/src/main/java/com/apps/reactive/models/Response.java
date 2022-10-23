package com.apps.reactive.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class Response {
    private String _index;
    private String _type;
    private String _id;
    private String _version;
    private String _seq_no;
    private String found;
    private User _source;
}
