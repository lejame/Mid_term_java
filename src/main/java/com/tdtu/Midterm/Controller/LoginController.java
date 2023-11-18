package com.tdtu.Midterm.Controller;

import com.tdtu.Midterm.Models.Model_Account;
import com.tdtu.Midterm.Repository.UserRepository;
import com.tdtu.Midterm.Service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
    private final LoginService login_register;
    private final UserRepository userRepository;
    public LoginController(LoginService loginRegister ,UserRepository userRepository) {
        login_register = loginRegister;
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login(){
        return "Login";
    }

    @PostMapping("/user_login")
    public RedirectView userLogin(@RequestParam("user") String  username, @RequestParam("pass") String password, Model phone){
        Model_Account user  = userRepository.findByUsername(username);
        if(user != null && user.getPass().equals(password) &&  user.getRole()==0){
            return new RedirectView("/home/"+user.getUsername());
        }
        else if(user != null && user.getPass().equals(password) &&  user.getRole()==1){
            return new RedirectView("/admin_home/"+user.getUsername());
        }
        else{
            return new RedirectView("error");
        }
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Model_Account());
        return "Register";
    }
    @PostMapping("/user_register")
    public String userRegister(@ModelAttribute("user") Model_Account user, Model model) {
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
}
