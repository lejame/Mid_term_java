package com.tdtu.Midterm.Controller;

import com.tdtu.Midterm.Models.Model_Account;
import com.tdtu.Midterm.Models.Model_Phone;
import com.tdtu.Midterm.Models.Model_Phone_Brand;
import com.tdtu.Midterm.Repository.UserRepository;
import com.tdtu.Midterm.Service.HomeProductService;
import com.tdtu.Midterm.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private final HomeProductService homeProductService;
    private final UserRepository userRepository;
    private final LoginService login_register;
    @Autowired
    public HomeController(HomeProductService homeProductService, UserRepository userRepository, LoginService loginRegister){
        this.homeProductService  =homeProductService;
        this.userRepository = userRepository;
        login_register = loginRegister;
    }
    @GetMapping("/trangchu")
    public String fetchAll(Model phone){
        // show data
        List<Model_Phone> phones = homeProductService.getbyAll();
        phone.addAttribute("phone",phones);

        // last phone
        List<Model_Phone> lastphone = homeProductService.getbyAll();
        phone.addAttribute("last_phone",lastphone.get(lastphone.size()-1));

        List<Model_Phone_Brand> brands = homeProductService.getbyBrand();
        phone.addAttribute("brand_phone",brands);


        return "Home";
    }
    @GetMapping("/login")
    public String login(){
        return "Login";
    }

    @PostMapping("/user_login")
    public String userLogin(@RequestParam("user") String  username,@RequestParam("pass") String password,Model phone){
        Model_Account user  = userRepository.findByUsername(username);
        System.out.println("username:"+username);
        System.out.println("Pass:"+password);
        if(user != null && user.getPass().equals(password) &&  user.getRole()==0){

            return "redirect:/trangchu";
        }
        else if(user != null && user.getPass().equals(password) &&  user.getRole()==1){
            return "redirect:/managementproduct";
        }
        else{
            return "error";
        }
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Model_Account());
        return "Register";
    }
    @PostMapping("/user_register")
    public String userRegister(@ModelAttribute("user") Model_Account user,Model model) {
        if(user.getPass().equals(user.getRe_pass())){
            // thông báo
            model.addAttribute("successMessage", "Đăng kí thành công");            // Lưu dữ liệu vào database
            // Lưu dữ liệu vào database
            login_register.addModel(user);
            return "redirect:/login";
        }
        else{
            // hiện thị thông báo
            model.addAttribute("errorMessage", "Mật khẩu không trùng khớp");
            return "redirect:/register";
        }
    }
    @GetMapping("/managementproduct")
    public String adminPage(Model phone){
        List<Model_Phone> phones = homeProductService.getbyAll();
        phone.addAttribute("phone",phones);
        return "ManagementProduct";
    }
}
