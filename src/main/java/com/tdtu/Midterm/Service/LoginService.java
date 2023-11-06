package com.tdtu.Midterm.Service;

import com.tdtu.Midterm.Models.Model_Account;
import com.tdtu.Midterm.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
