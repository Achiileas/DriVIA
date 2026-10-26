package com.example.dataserver;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String model;
    private String category;
    private String location;

    public Integer getId() { return id; }
    public String getModel() { return model; }
    public String getCategory() { return category; }
    public String getLocation() { return location; }
}