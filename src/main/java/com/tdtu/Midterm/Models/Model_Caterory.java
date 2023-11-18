package com.tdtu.Midterm.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
public class Model_Caterory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_caterory;

    private String name;
    public Model_Caterory(){
        id_caterory = 0;
    }
}
