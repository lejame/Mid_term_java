package com.tdtu.Midterm.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Entity
@Data
@AllArgsConstructor
@Setter
public class Model_Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_status;

    private int payed;
    private int stored;
    public Model_Status() {
        id_status = 0;
    }
}
