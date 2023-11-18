package com.tdtu.Midterm.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Model_Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String img;
    private int price;
    private String color;
    private String description;
    // xet thuoc tinh khoa ngoại cho brand
    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Model_Phone_Brand phoneBrand;

    @ManyToOne
    @JoinColumn(name = "id_caterory")
    public Model_Caterory model_caterory;
    public Model_Phone(String name,String img,int price,String color,String description,Model_Phone_Brand phoneBrand,Model_Caterory model_caterory){
        this.name = name;
        this.img = img;
        this.price = price;
        this.color = color;
        this.phoneBrand = phoneBrand;
        this.model_caterory = model_caterory;
        this.description =description;
    }

    public Model_Phone() {
        id = 0;
    }
}
