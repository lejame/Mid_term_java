package com.tdtu.Midterm.Repository;

import com.tdtu.Midterm.Models.Model_Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Home_Product extends JpaRepository<Model_Phone,Integer> {
    List<Model_Phone> findAllByName(String name);
    Model_Phone findById(int id);

}
