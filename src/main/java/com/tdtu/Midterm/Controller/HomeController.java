package com.tdtu.Midterm.Controller;

import com.tdtu.Midterm.Models.Model_Account;
import com.tdtu.Midterm.Models.Model_Phone;
import com.tdtu.Midterm.Models.Model_Phone_Brand;
import com.tdtu.Midterm.Service.HomeProductService;
import com.tdtu.Midterm.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;
import java.util.Optional;

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

    @GetMapping("/home/search")
    public String seachProducts(@RequestParam("query") String query,Model model){
        List<Model_Phone> phone = homeProductService.searchPhones(query);
        model.addAttribute("phone",phone);

        // last phone
        List<Model_Phone> lastphone = homeProductService.getbyAll();
        model.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

        List<Model_Phone_Brand> brands =homeProductService.getByBrand();
        model.addAttribute("brand_phone",brands);
        return "Home";
    }

    @GetMapping("/home/search_brand/{name}")
    public String seachProductsByBrand(@PathVariable("name") String query,Model model){
        List<Model_Phone> phone = homeProductService.searchPhonesByBrand(query);
        model.addAttribute("phone",phone);

        // last phone
        List<Model_Phone> lastphone = homeProductService.getbyAll();
        model.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

        List<Model_Phone_Brand> brands =homeProductService.getByBrand();
        model.addAttribute("brand_phone",brands);
        return "Home";
    }
    @GetMapping("/home/search_all")
    public String searchProductByBrandPriceCaterogy(@RequestParam("brand") int brand,@RequestParam("caterory") int caterory,@RequestParam("price") int price,Model model){

        if(caterory==0 || brand == 0 || price ==0){
            List<Model_Phone> phone = homeProductService.findByBrandCateroryPrice(brand,caterory,price);
            model.addAttribute("phone",phone);

            // last phone
            List<Model_Phone> lastphone = homeProductService.getbyAll();
            model.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

            List<Model_Phone_Brand> brands =homeProductService.getByBrand();
            model.addAttribute("brand_phone",brands);
            return "Home";
        }
        else{
            List<Model_Phone> phone = homeProductService.findByBrandCateroryPrice(brand,caterory,price);
            model.addAttribute("phone",phone);

            // last phone
            List<Model_Phone> lastphone = homeProductService.getbyAll();
            model.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

            List<Model_Phone_Brand> brands =homeProductService.getByBrand();
            model.addAttribute("brand_phone",brands);
            return "Home";
        }
    }
    // user
    @GetMapping("/home/search_user/{user}")
    public String seachProductsForUser(@PathVariable("user") String user,@RequestParam("query") String query,Model model){
        List<Model_Phone> phone = homeProductService.searchPhones(query);
        model.addAttribute("phone",phone);

        // last phone
        List<Model_Phone> lastphone = homeProductService.getbyAll();
        model.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

        List<Model_Phone_Brand> brands =homeProductService.getByBrand();
        model.addAttribute("brand_phone",brands);
        Model_Account account = account_user.getAccountByName(user);
        model.addAttribute("username",account);
        return "UserHome";
    }
    @GetMapping("/home/search_brand_user/{name}/{query}")
    public String seachProductsByBrandForUser(@PathVariable("name") String name,@PathVariable("query") String query,Model model){
        List<Model_Phone> phone = homeProductService.searchPhonesByBrand(query);
        model.addAttribute("phone",phone);

        // last phone
        List<Model_Phone> lastphone = homeProductService.getbyAll();
        model.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

        List<Model_Phone_Brand> brands =homeProductService.getByBrand();
        model.addAttribute("brand_phone",brands);
        Model_Account account = account_user.getAccountByName(name);
        model.addAttribute("username",account);
        return "UserHome";
    }
    @GetMapping("/home/search_all_user/{username}")
    public String searchBrandCateroryPrice(@PathVariable("username") String name,@RequestParam("brand") int brand,@RequestParam("caterory") int caterory,@RequestParam("price") int price,Model model){
        if(caterory==0 || brand == 0 || price ==0){
            List<Model_Phone> phone = homeProductService.findByBrandCateroryPrice(brand,caterory,price);
            model.addAttribute("phone",phone);

            // last phone
            List<Model_Phone> lastphone = homeProductService.getbyAll();
            model.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

            List<Model_Phone_Brand> brands =homeProductService.getByBrand();
            model.addAttribute("brand_phone",brands);
            Model_Account account = account_user.getAccountByName(name);
            model.addAttribute("username",account);

            return "UserHome";
        }
        else {
            List<Model_Phone> phone = homeProductService.findByBrandCateroryPrice(brand,caterory,price);
            model.addAttribute("phone",phone);

            // last phone
            List<Model_Phone> lastphone = homeProductService.getbyAll();
            model.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

            List<Model_Phone_Brand> brands =homeProductService.getByBrand();
            model.addAttribute("brand_phone",brands);
            Model_Account account = account_user.getAccountByName(name);
            model.addAttribute("username",account);

            return "UserHome";
        }
    }
    // admin
    @GetMapping("/home/search_admin/{user}")
    public String seachProductsForAdmin(@PathVariable("user") String user,@RequestParam("query") String query,Model model){
        List<Model_Phone> phone = homeProductService.searchPhones(query);
        model.addAttribute("phone",phone);

        // last phone
        List<Model_Phone> lastphone = homeProductService.getbyAll();
        model.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

        List<Model_Phone_Brand> brands =homeProductService.getByBrand();
        model.addAttribute("brand_phone",brands);
        Model_Account account = account_user.getAccountByName(user);
        model.addAttribute("username",account);
        return "AdminHome";
    }
    @GetMapping("/home/search_brand_admin/{name}/{query}")
    public String seachProductsByBrandForAdmin(@PathVariable("name") String name,@PathVariable("query") String query,Model model){
        List<Model_Phone> phone = homeProductService.searchPhonesByBrand(query);
        model.addAttribute("phone",phone);

        // last phone
        List<Model_Phone> lastphone = homeProductService.getbyAll();
        model.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

        List<Model_Phone_Brand> brands =homeProductService.getByBrand();
        model.addAttribute("brand_phone",brands);
        Model_Account account = account_user.getAccountByName(name);
        model.addAttribute("username",account);
        return "AdminHome";
    }

    @GetMapping("/home/search_all_admin/{username}")
    public RedirectView searchBrandCateroryPrice_admin(@PathVariable("username") String name,@RequestParam("brand") int brand,@RequestParam("caterory") int caterory,@RequestParam("price") int price,Model model){
        if(caterory==0 || brand == 0 || price ==0){
            List<Model_Phone> phone = homeProductService.findByBrandCateroryPrice(brand,caterory,price);
            model.addAttribute("phone",phone);

            // last phone
            List<Model_Phone> lastphone = homeProductService.getbyAll();
            model.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

            List<Model_Phone_Brand> brands =homeProductService.getByBrand();
            model.addAttribute("brand_phone",brands);
            Model_Account account = account_user.getAccountByName(name);
            model.addAttribute("username",account);

            return new RedirectView("/admin_home/"+name);
        }
        else {
            List<Model_Phone> phone = homeProductService.findByBrandCateroryPrice(brand,caterory,price);
            model.addAttribute("phone",phone);

            // last phone
            List<Model_Phone> lastphone = homeProductService.getbyAll();
            model.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

            List<Model_Phone_Brand> brands =homeProductService.getByBrand();
            model.addAttribute("brand_phone",brands);
            Model_Account account = account_user.getAccountByName(name);
            model.addAttribute("username",account);

            return new RedirectView("/admin_home/"+name);
        }
    }
}
