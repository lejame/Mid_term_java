package com.tdtu.Midterm.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.print.attribute.standard.JobImpressions;

@Data
@Entity
@Getter
@Setter
public class Model_UserShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usershopping;

    @ManyToOne
    @JoinColumn(name = "id")
    private Model_Phone phone;

    @ManyToOne
    @JoinColumn(name="id_account")
    private Model_Account account;

    private int amount;
    public Model_UserShoppingCart(){
        id_usershopping = 0;
    }
    public Model_UserShoppingCart(Model_Phone phone,int amount,Model_Account account){
        this.phone = phone;
        this.amount= amount;
        this.account = account;
    }

}
