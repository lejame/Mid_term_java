package com.tdtu.Midterm.Repository;

import com.tdtu.Midterm.Models.Model_UserShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserShoppingCartRepository extends JpaRepository<Model_UserShoppingCart,Integer> {
}
