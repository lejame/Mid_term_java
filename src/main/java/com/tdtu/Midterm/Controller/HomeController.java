package com.tdtu.Midterm.Controller;

import com.tdtu.Midterm.Models.Model_Account;
import com.tdtu.Midterm.Models.Model_Phone;
import com.tdtu.Midterm.Models.Model_Phone_Brand;
import com.tdtu.Midterm.Service.HomeProductService;
import com.tdtu.Midterm.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class HomeController {
    private final HomeProductService homeProductService;
    private final LoginService account_user;
    @Autowired
    public HomeController(HomeProductService homeProductService, LoginService loginRegister, LoginService account){
        this.homeProductService  =homeProductService;

        this.account_user = account;
    }

    @GetMapping("/home")
    public String fetchAll(Model phone){
        // show data
        List<Model_Phone> phones = homeProductService.getbyAll();
        phone.addAttribute("phone",phones);

        // last phone
        List<Model_Phone> lastphone = homeProductService.getbyAll();
        phone.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

        List<Model_Phone_Brand> brands =homeProductService.getByBrand();
        phone.addAttribute("brand_phone",brands);

        return "Home";
    }
    @GetMapping("/home/{name}")
    public String showHome(@PathVariable("name") String name,Model phone){
        // show data
        List<Model_Phone> phones = homeProductService.getbyAll();
        phone.addAttribute("phone",phones);

        // last phone
        List<Model_Phone> lastphone = homeProductService.getbyAll();
        phone.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

        List<Model_Phone_Brand> brands =homeProductService.getByBrand();
        phone.addAttribute("brand_phone",brands);

        Model_Account account = account_user.getAccountByName(name);
        phone.addAttribute("username",account);
        return "UserHome";
    }

    @GetMapping("/admin_home/{name}")
    public String showAdminHome(@PathVariable("name") String name,Model phone, RedirectAttributes redirectAttributes)
    {
        List<Model_Phone> phones = homeProductService.getbyAll();
        phone.addAttribute("phone",phones);

        // last phone
        List<Model_Phone> lastphone = homeProductService.getbyAll();
        phone.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

        List<Model_Phone_Brand> brands =homeProductService.getByBrand();
        phone.addAttribute("brand_phone",brands);

        Model_Account account = account_user.getAccountByName(name);
        phone.addAttribute("username",account);

        return "AdminHome";
    }

}
