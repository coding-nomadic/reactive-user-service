package com.apps.reactive.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String occupation;
    private String age;
    private String dateOfBirth;
}
