package com.openbanking.openbanking.beans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {
    private String type;
    private Date date;
    private long accountNumber;
    private String currency;
    private double amount;
    private String merchantLogo;

    
}

