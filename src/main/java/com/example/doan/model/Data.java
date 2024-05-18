package com.example.doan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Data {
    private String type;
    private String title;
    private String body;
    private double longitude;
    private double latitude;
    private String source;
    private String list_question;
    

    // Constructors, getters, and setters
}
