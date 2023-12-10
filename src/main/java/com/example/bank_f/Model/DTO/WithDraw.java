package com.example.bank_f.Model.DTO;

import lombok.Data;

@Data
public class WithDraw {
    private double current_balance;
    private double withdraw;
    private double after_balance;
    private String status;
}
