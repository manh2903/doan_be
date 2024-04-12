package com.example.doan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice implements Serializable {

    private String title;
    private String body;
    private double longitude;
    private double latitude;
    private List<String> token;
}

