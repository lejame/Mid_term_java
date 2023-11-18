package com.tdtu.Midterm.Service;

import com.tdtu.Midterm.Models.Model_Account;
import com.tdtu.Midterm.Models.Model_Phone;
import com.tdtu.Midterm.Models.Model_UserShoppingCart;
import com.tdtu.Midterm.Repository.CartRepository;
import com.tdtu.Midterm.Repository.UserShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {
    @Autowired
    private final  CartRepository cartRepository;

    @Autowired
    private final UserShoppingCartRepository userShoppingCartRepository;


    public Optional<Model_Phone> findByID(int id){
        return cartRepository.findById(id);
    }

    public List<Model_UserShoppingCart> getProductByIdAccount(Model_Account model) {
        List<Model_UserShoppingCart> productList = userShoppingCartRepository.findAll();
        List<Model_UserShoppingCart> shoppingCartList = new ArrayList<>();
        // Tìm sản phẩm trong danh sách dựa trên id account
        for (Model_UserShoppingCart product : productList) {
            if (product.getAccount().getId_account() == model.getId_account()) {
                shoppingCartList.add(product);
            }
        }
        return shoppingCartList;
    }



    public CartService(CartRepository cartRepository, UserShoppingCartRepository userShoppingCartRepository){
        this.cartRepository = cartRepository;
        this.userShoppingCartRepository = userShoppingCartRepository;
    }
    public List<Model_UserShoppingCart> fetchAllPhone(){
        return userShoppingCartRepository.findAll();
    }
    public void addItem(Model_UserShoppingCart item) {
        userShoppingCartRepository.save(item);
    }

    public void removeItem(Model_UserShoppingCart item) {
        userShoppingCartRepository.deleteById(item.getId_usershopping());
    }


    public double getTotalPrice(List<Model_UserShoppingCart> userphoneList) {
        double totalPrice = 0.0;
        for (Model_UserShoppingCart item : userphoneList) {
            totalPrice += item.getPhone().getPrice() * item.getAmount(); // Tính tổng giá tiền của các mặt hàng trong giỏ hàng
        }
        return totalPrice;
    }


    public boolean deletePhoneById(Model_UserShoppingCart modelUserShoppingCart) {
        try {
            userShoppingCartRepository.delete(modelUserShoppingCart);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
