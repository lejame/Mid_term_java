package com.tdtu.Midterm.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import javax.persistence.*;

@Entity
public class Model_Phone_Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_brand;
    private String name;

}
