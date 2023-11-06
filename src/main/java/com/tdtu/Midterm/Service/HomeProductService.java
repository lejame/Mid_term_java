package com.tdtu.Midterm.Service;


import com.tdtu.Midterm.Models.Model_Account;
import com.tdtu.Midterm.Models.Model_Phone;
import com.tdtu.Midterm.Models.Model_Phone_Brand;
import com.tdtu.Midterm.Repository.Home_Product;
import com.tdtu.Midterm.Repository.Home_Product_Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeProductService {
    private final Home_Product homeProductRepository;
    private final Home_Product_Brand home_product_brands;
    @Autowired
    public  HomeProductService(Home_Product homeProduct_Repository, Home_Product_Brand homeProductBrands){
        this.homeProductRepository=homeProduct_Repository;
        this.home_product_brands = homeProductBrands;
    }
    public List<Model_Phone> getHomeProductByName(String name){
        return homeProductRepository.findAllByName(name);
    }
    public List<Model_Phone> getbyAll(){

        return homeProductRepository.findAll();
    }
    public List<Model_Phone_Brand> getbyBrand(){
        return home_product_brands.findAll();
    }

}
