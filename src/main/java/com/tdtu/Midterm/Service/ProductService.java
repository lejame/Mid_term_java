package com.tdtu.Midterm.Service;

import com.tdtu.Midterm.Models.Model_Phone;
import com.tdtu.Midterm.Repository.Home_Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final Home_Product product;
    @Autowired
    public ProductService(Home_Product product){
        this.product = product;
    }
    public void addProduct(Model_Phone phone){
        product.save(phone);
    }
}
