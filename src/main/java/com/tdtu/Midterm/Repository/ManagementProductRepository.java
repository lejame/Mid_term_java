package com.tdtu.Midterm.Repository;

import com.tdtu.Midterm.Models.Model_Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagementProductRepository extends JpaRepository<Model_Phone,Integer> {
    
}
