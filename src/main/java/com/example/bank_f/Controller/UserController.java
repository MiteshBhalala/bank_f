package com.example.bank_f.Controller;
import com.example.bank_f.Model.User;
import com.example.bank_f.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    private User addUser(@RequestBody User u){
        return userService.addUser(u);
    }

    @GetMapping("/getuser")
    private List<User> getUser(){
        return userService.getUser();
    }


}
