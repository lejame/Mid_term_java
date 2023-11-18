package com.tdtu.Midterm.Controller;

import com.tdtu.Midterm.Models.Model_Caterory;
import com.tdtu.Midterm.Models.Model_Phone;
import com.tdtu.Midterm.Models.Model_Phone_Brand;
import com.tdtu.Midterm.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller

public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/phone_management/{username}")
    public String showEditForm(@PathVariable("username")String name, Model model,RedirectAttributes redirectAttributes){
        List<Model_Phone> modelPhones = adminService.getbyAll();
        List<Model_Phone_Brand> modelPhoneBrands = adminService.getAllByBrand();
        List<Model_Caterory> modelCaterories = adminService.getAllByCaterory();
        model.addAttribute("phone",modelPhones);
        model.addAttribute("phone_brand",modelPhoneBrands);
        model.addAttribute("phone_caterory",modelCaterories);
        redirectAttributes.addAttribute("username",name);
        return "ManagementProduct";
    }
    @PostMapping("/phone_management/{name}")
    public RedirectView addPhone(@PathVariable("name") String username,@RequestParam("color") String color, @RequestParam("image") String image, @RequestParam("name") String name, @RequestParam("price") int price, @RequestParam(name = "description") String description, @RequestParam("id_brand") int id_brand, @RequestParam("id_caterory") int id_cater){
        Optional<Model_Phone_Brand> brand = adminService.getByIdBrand(id_brand);
        Optional<Model_Caterory> caterory = adminService.getByIdCaterory(id_cater);
        adminService.add_model_phone(new Model_Phone(name,image,price,color,description,brand.get(),caterory.get()));
        return new RedirectView("/phone_management/"+username);
    }

    @GetMapping("/phone/delete/{id}")
    public RedirectView deletePhone(@PathVariable("id") int  id){
        boolean check_phone = adminService.deletePhoneById(id);
        if(check_phone){
            return new RedirectView("/phone_management/admin");
        }
        return new RedirectView("error");
    }
    @GetMapping("/phone/edit/{id}")
    public String editFrom(@PathVariable("id") int id,Model model){
        Optional<Model_Phone> phone = adminService.getByIdPhone(id);
        model.addAttribute("inf_phone",phone.get());
        return "updatephone";
    }
//    @GetMapping("/phone/update/{id}")
//    public RedirectView updatePhone(@PathVariable("id") int id){
//
//
//    }
}
