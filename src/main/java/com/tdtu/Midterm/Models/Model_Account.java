package com.tdtu.Midterm.Models;

import jakarta.persistence.*;
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
    @Transient
    private String re_pass;

    public Model_Account() {
        id_account = 0;
    }

}
