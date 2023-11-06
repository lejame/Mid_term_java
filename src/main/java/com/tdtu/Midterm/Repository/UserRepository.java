package com.tdtu.Midterm.Repository;

import com.tdtu.Midterm.Models.Model_Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Model_Account, Integer> {
    Model_Account findByUsername(String name);

}
