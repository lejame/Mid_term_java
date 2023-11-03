package com.tdtu.Midterm.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Model_Acount {
    @Id
    private String username;
    private String passwork;
}
