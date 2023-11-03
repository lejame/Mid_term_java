package com.tdtu.Midterm.Controller;

import com.tdtu.Midterm.Entity.Info_product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("")
    public String fetchAll(Model phone){
        List<Info_product> phones = new ArrayList<>();
        phones.add(new Info_product(1,"Iphone 15","https://www.pngmart.com/files/15/Apple-iPhone-12-PNG-HD.png",1000,"Sản phẩm mới nhất",1));
        phone.addAttribute("phone",phones);
        return "abc";
    }
}
