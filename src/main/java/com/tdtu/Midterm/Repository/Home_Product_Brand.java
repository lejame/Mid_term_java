package com.tdtu.Midterm.Repository;
import com.tdtu.Midterm.Models.Model_Phone;
import com.tdtu.Midterm.Models.Model_Phone_Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface Home_Product_Brand extends JpaRepository<Model_Phone_Brand,Integer> {

}
