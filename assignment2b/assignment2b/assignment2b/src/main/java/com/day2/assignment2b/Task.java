package com.day2.assignment2b;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Task {
    private int ID;
    private String title, desc, status;
}
