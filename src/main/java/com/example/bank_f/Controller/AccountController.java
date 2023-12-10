package com.example.bank_f.Controller;

import com.example.bank_f.Model.Account;
import com.example.bank_f.Model.DTO.Transfer;
import com.example.bank_f.Model.DTO.WithDraw;
import com.example.bank_f.Service.AccountService;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/addaccount")
    private Account addAccount(@RequestBody Account a){
        return accountService.addAccount(a);
    }

    @GetMapping("/getaccount")
    private List<Account> getAccount(){
        return accountService.getAccount();
    }
    @PutMapping("/withdraw")
    private WithDraw withdraw (@RequestParam String accountNumber , @RequestParam Double amount){
        return accountService.withdraw(accountNumber,amount);
    }

    @PutMapping("/transfer")
    private Transfer transfer(@RequestParam String sender, @RequestParam double amount, @RequestParam String receiver){
        return accountService.transfer(sender,amount,receiver);
    }

    @PutMapping("deposit")
    private Double deposit(@RequestParam String accountNumber,@RequestParam Double amount){
        return accountService.deposit(accountNumber,amount);
    }





}
