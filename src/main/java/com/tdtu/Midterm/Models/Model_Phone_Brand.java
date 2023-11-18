package com.tdtu.Midterm.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Data
@Entity
@AllArgsConstructor
@Getter
@Setter
public class Model_Phone_Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_brand")
    private int id_brand;
    private String name;


    public Model_Phone_Brand() {
        id_brand = 0;
    }
}
