package com.tdtu.Midterm.Service;

import com.tdtu.Midterm.Models.Model_Account;
import com.tdtu.Midterm.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    private final UserRepository userRepository;
    @Autowired
    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void addModel(Model_Account account){
        userRepository.save(account);
    }

    public Optional<Model_Account> getAccount(int id){
        return userRepository.findById(id);
    }

    public Model_Account getAccountByName(String name){
        return userRepository.findByUsername(name);
    }

}
