package com.tdtu.Midterm.Controller;

import com.tdtu.Midterm.Models.Model_Account;
import com.tdtu.Midterm.Models.Model_Phone;
import com.tdtu.Midterm.Service.HomeProductService;
import com.tdtu.Midterm.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetailController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private HomeProductService homeProductService;
    @RequestMapping("/detailProduct/{username}/{id}")
    public String showDetailProduct(@PathVariable("id") int id, @PathVariable("username") String name, Model phone){
        //show data
        Model_Phone phones = homeProductService.getPhoneById(id);
        Model_Account userAccount = loginService.getAccountByName(name);
        phone.addAttribute("phone_detail",phones);
        phone.addAttribute("usernamedetails",userAccount);
        return "Detail";
    }

    @RequestMapping("/detailProduct/{id}")
    public String showDetailProduct(@PathVariable("id") int id, Model phone){
        //show data
        Model_Phone phones = homeProductService.getPhoneById(id);
        phone.addAttribute("phone_detail",phones);
        return "DetailsNoUser";
    }

}
