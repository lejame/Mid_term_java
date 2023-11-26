package com.tdtu.Midterm.Repository;

import com.tdtu.Midterm.Models.Model_Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Home_Product extends JpaRepository<Model_Phone,Integer> {
    List<Model_Phone> findAllByName(String name);
    Model_Phone findById(int id);

    @Query("Select p from  Model_Phone p where p.name Like concat('%',:query,'%')")
    List<Model_Phone> searchPhones(String query);
    @Query("select p from Model_Phone p where p.phoneBrand.name Like concat('%',:brand,'%')")
    List<Model_Phone> seachPhonesByBrand(String brand);

    @Query("SELECT p FROM Model_Phone p WHERE p.phoneBrand.id_brand = :brand AND p.price <= :price AND p.model_caterory.id_caterory = :category")
    List<Model_Phone> findByBrandAndPriceAndCategory(@Param("brand") int brand, @Param("price") int price, @Param("category") int category);

}
