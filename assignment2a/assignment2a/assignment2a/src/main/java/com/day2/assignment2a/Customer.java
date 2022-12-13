package com.day2.assignment2a;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Customer {
    private int ID;
    private double balance;
    private String username;
}
