package com.tdtu.Midterm.Controller;

import com.tdtu.Midterm.Models.Model_Phone;
import com.tdtu.Midterm.Models.Model_Phone_Brand;
import com.tdtu.Midterm.Models.Model_Status;
import com.tdtu.Midterm.Repository.Home_Product;
import com.tdtu.Midterm.Service.HomeProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class HomeController {
    private HomeProductService homeProductl;
    @GetMapping("/trangchu")
    public String fetchAll(Model phone){
        List<Model_Phone> phones = homeProductl.getbyAll();
        phone.addAttribute("phone",phones);
        return "Home";
    }

}
