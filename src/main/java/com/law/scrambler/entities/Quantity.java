package com.law.scrambler.entities;

import org.springframework.data.annotation.Id;

public class Quantity {
    @Id
    public Long id;

    public String name;

    public Quantity (String name) {
        this.name = name;
    }
}
