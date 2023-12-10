package com.example.bank_f.Service;

import com.example.bank_f.Model.Account;
import com.example.bank_f.Model.DTO.Transfer;
import com.example.bank_f.Model.DTO.WithDraw;
import com.example.bank_f.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account addAccount(Account a) {
        return accountRepository.save(a);
    }

    public List<Account> getAccount() {
        return accountRepository.findAll();
    }

    public WithDraw withdraw(String accountNumber, Double amount) {
        Account a = accountRepository.findByAccountNumber(accountNumber);

        WithDraw wd = new WithDraw();

        double current_balance = a.getBalance();

        if (current_balance < amount){
            wd.setCurrent_balance(current_balance);
            wd.setWithdraw(amount);
            wd.setAfter_balance(current_balance);
            wd.setStatus("Insuffcient Balance: \"NOT TRANSFER\" ");
            return wd;
        }
        double after_withdraw = current_balance - amount;
        a.setBalance(after_withdraw);
        accountRepository.save(a);

        wd.setCurrent_balance(current_balance);
        wd.setWithdraw(amount);
        wd.setAfter_balance(after_withdraw);
        wd.setStatus(" \"WITHDRAW SUCCESS\" ");
        return wd;
    }

    public Transfer transfer(String sender, double amount, String receiver) {
        Account s = accountRepository.findByAccountNumber(sender);
        Account r = accountRepository.findByAccountNumber(receiver);

        Transfer td = new Transfer();

        double s_balance = s.getBalance();
        double r_balance = r.getBalance();

        if (s_balance < amount){
            td.setSendernum(s.getAccountNumber());
            td.setSenderbalance(s_balance);
            td.setAftersend(s_balance);
            td.setRecenum(r.getAccountNumber());
            td.setRecebalance(r_balance);
            td.setAfterrece(r_balance);

            td.setStatus("Unsuccess Transfer!");
            return td;
        }

        s.setBalance(s_balance - amount);
        r.setBalance(r_balance + amount);;

        accountRepository.save(s);
        accountRepository.save(r);

        td.setSendernum(s.getAccountNumber());
        td.setSenderbalance(s_balance);
        td.setAftersend(s_balance - amount);
        td.setRecenum(r.getAccountNumber());
        td.setRecebalance(r_balance);
        td.setAfterrece(r_balance + amount);

        td.setStatus("success Transfer!");
        return td;

    }

    public Double deposit(String accountNumber, Double amount) {
        Account a = accountRepository.findByAccountNumber(accountNumber);

        double current_balance = a.getBalance();
        double after_deposit = current_balance + amount;
        a.setBalance(after_deposit);
        accountRepository.save(a);
        return after_deposit;
    }
}
