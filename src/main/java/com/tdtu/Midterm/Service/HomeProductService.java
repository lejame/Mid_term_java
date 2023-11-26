package com.tdtu.Midterm.Service;


import com.tdtu.Midterm.Models.Model_Phone;
import com.tdtu.Midterm.Models.Model_Phone_Brand;
import com.tdtu.Midterm.Repository.Home_Product;
import com.tdtu.Midterm.Repository.ModelPhoneBrandRepository;
import com.tdtu.Midterm.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeProductService{
    private final Home_Product homeProductRepository;
    private final ModelPhoneBrandRepository modelPhoneBrandRepository;

    @Autowired
    public  HomeProductService(Home_Product homeProduct_Repository, ModelPhoneBrandRepository modelPhoneBrandRepository, UserRepository userRepository){
        this.homeProductRepository=homeProduct_Repository;
        this.modelPhoneBrandRepository = modelPhoneBrandRepository;
    }
    public List<Model_Phone> getHomeProductByName(String name){
        return homeProductRepository.findAllByName(name);
    }
    public List<Model_Phone> getbyAll(){

        return homeProductRepository.findAll();
    }
    public Model_Phone getPhoneById(int id){
        return homeProductRepository.findById(id);
    }
    public List<Model_Phone_Brand> getByBrand(){
        return modelPhoneBrandRepository.findAll();
    }
    public List<Model_Phone> searchPhones(String query){
        List<Model_Phone> products = homeProductRepository.searchPhones(query);
        return products;
    }
    public List<Model_Phone> searchPhonesByBrand(String query){
        List<Model_Phone> products = homeProductRepository.seachPhonesByBrand(query);
        return products;
    }
    public List<Model_Phone> findByBrandCateroryPrice(int brand,int category,int price){
        return homeProductRepository.findByBrandAndPriceAndCategory(brand,price,category);
    }
}
