package com.tdtu.Midterm.Service;


import com.tdtu.Midterm.Models.Model_Phone;
import com.tdtu.Midterm.Repository.Home_Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeProductService {
    private final Home_Product homeProductRepository;
    @Autowired
    public  HomeProductService(Home_Product homeProduct_Repository){
        this.homeProductRepository=homeProduct_Repository;
    }
    public List<Model_Phone> getHomeProductByName(String name){
        return homeProductRepository.findAllByName(name);
    }

}
