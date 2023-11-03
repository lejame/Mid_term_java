package com.tdtu.Midterm.Models;

import jakarta.persistence.*;

@Entity
public class Model_Phone{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String img;
    private double price;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Model_Phone_Brand phoneBrand;
}
