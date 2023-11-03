package com.tdtu.Midterm.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@AllArgsConstructor
@Getter
@Setter
public class Model_Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_account;
    private String username;
    private String pass;
    private int Role;

    public Model_Account() {
        id_account = 0;
    }

}
