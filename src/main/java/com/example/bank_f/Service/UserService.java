package com.example.bank_f.Service;

import com.example.bank_f.Model.User;
import com.example.bank_f.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User u) {
        return userRepository.save(u);
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }
}
