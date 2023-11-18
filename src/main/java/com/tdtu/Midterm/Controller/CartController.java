package com.tdtu.Midterm.Controller;

import com.tdtu.Midterm.Models.Model_Account;
import com.tdtu.Midterm.Models.Model_Phone;
import com.tdtu.Midterm.Models.Model_UserShoppingCart;
import com.tdtu.Midterm.Service.CartService;
import com.tdtu.Midterm.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private LoginService user;

    @GetMapping("/addToCart/{id}/{quantity}/{name}")
    public RedirectView addToCart(@PathVariable("id") int cartId, @PathVariable("quantity") int quantity, @PathVariable("name") String name, RedirectAttributes redirectAttributes) {
        Optional<Model_Phone> cartOptional = cartService.findByID(cartId);
        List<Model_UserShoppingCart> listcart = cartService.fetchAllPhone();
        Model_Account account = user.getAccountByName(name);
        boolean checkValue = false;
        for (Model_UserShoppingCart modelUserShoppingCart : listcart) {
            if (cartOptional.get().getId() == modelUserShoppingCart.getPhone().getId()) {
                int quantitys = modelUserShoppingCart.getAmount();
                cartService.removeItem(modelUserShoppingCart);
                cartService.addItem(new Model_UserShoppingCart(cartOptional.get(), quantitys + quantity, account));
                checkValue = true;
            }
        }

        if (!checkValue) {
            cartService.addItem(new Model_UserShoppingCart(cartOptional.get(), quantity, account));
        }
        redirectAttributes.addAttribute("id", cartId);
        redirectAttributes.addAttribute("name", name);
        return new RedirectView("/detailProduct/{name}/{id}");
    }

    @GetMapping("/cart/{name}")
    public String viewCart(@PathVariable("name") String name,Model model) {
        Model_Account user_account = user.getAccountByName(name);
        System.out.println(user_account.toString());
        List<Model_UserShoppingCart> list_cart = cartService.getProductByIdAccount(user_account);
        System.out.println(list_cart.size());
        double money = cartService.getTotalPrice(list_cart);
        model.addAttribute("money", money);
        model.addAttribute("list_cart", list_cart);
        model.addAttribute("user_account",user_account);
        return "Cart";
    }
    @GetMapping("/update/{id_phone}/{name}/{quantity}")
    public RedirectView updateProduct(@PathVariable("id_phone") int id_cart,@PathVariable("name") String name,@PathVariable("quantity") int quantity, RedirectAttributes redirectAttributes){
        Optional<Model_Phone> cartOptional = cartService.findByID(id_cart);
        List<Model_UserShoppingCart> listcart = cartService.fetchAllPhone();
        Model_Account account = user.getAccountByName(name);
        for (Model_UserShoppingCart modelUserShoppingCart : listcart) {
            if (cartOptional.get().getId() == modelUserShoppingCart.getPhone().getId()) {
                int quantitys = modelUserShoppingCart.getAmount();
                cartService.removeItem(modelUserShoppingCart);
                cartService.addItem(new Model_UserShoppingCart(cartOptional.get(), quantitys + 1, account));
            }
        }
        redirectAttributes.addAttribute("name",name);
        return new RedirectView("/cart/{name}");
    }
    @GetMapping("/delete/{id_phone}/{name}/{quantity}")
    public RedirectView deleteProduct(@PathVariable("id_phone") int id_phone,@PathVariable("name") String name,@PathVariable("quantity") int quantity, RedirectAttributes redirectAttributes){
        Model_Phone cartOptional = cartService.findByID(id_phone).get();
        List<Model_UserShoppingCart> listcart = cartService.fetchAllPhone();
        Model_Account account = user.getAccountByName(name);
        for (Model_UserShoppingCart modelUserShoppingCart : listcart) {
            if (cartOptional.getId() == modelUserShoppingCart.getPhone().getId()) {
                int quantitys = modelUserShoppingCart.getAmount();
                if(quantitys>0) {
                    cartService.removeItem(modelUserShoppingCart);
                    cartService.addItem(new Model_UserShoppingCart(cartOptional, quantitys - 1, account));
                }
                else{
                    cartService.deletePhoneById(modelUserShoppingCart);
                }
            }
        }
        redirectAttributes.addAttribute("name",name);
        return new RedirectView("/cart/{name}");
    }

    @GetMapping("/btn_delete/{id}/{name}")
    public RedirectView btndeleleProduct(@PathVariable("id") int id,@PathVariable("name") String name,RedirectAttributes redirectAttributes){
        List<Model_UserShoppingCart> shoppingCartList = cartService.fetchAllPhone();
        for(Model_UserShoppingCart modelUserShoppingCart:shoppingCartList){
            if(modelUserShoppingCart.getPhone().getId()==id){
                cartService.deletePhoneById(modelUserShoppingCart);
                redirectAttributes.addAttribute("name",name);
                return new RedirectView("/cart/{name}");
            }
        }
        redirectAttributes.addAttribute("name",name);
        return new RedirectView("/cart/{name}");
    }

}

