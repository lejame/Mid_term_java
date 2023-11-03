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
    private double price;
    private String color;
    // xet thuoc tinh khoa ngoại cho brand
    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Model_Phone_Brand phoneBrand;

    // xét thuộc tính khóa ngoại cho tình trạng
    @OneToOne(mappedBy = "")
    @JoinColumn(name = "id_status")
    private Model_Status phoneStatus;
    public Model_Phone() {
        id = 0;
    }

}
