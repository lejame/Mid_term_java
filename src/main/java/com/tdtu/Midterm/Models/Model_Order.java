package com.tdtu.Midterm.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Model_Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_order;

    @ManyToOne
    @JoinColumn(name = "id_account")
    private Model_Account accountS;

    @ManyToOne
    @JoinColumn(name = "id_phone")
    private Model_Phone phones;


}
