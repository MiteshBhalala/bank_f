package com.example.bank_f.Model.DTO;

import lombok.Data;

@Data
public class Transfer {

    //sender
    private String sendernum;
    private double senderbalance;
    private double aftersend;


    //receiver
    private String recenum;
    private double recebalance;
    private double afterrece;

    private String status;
}
