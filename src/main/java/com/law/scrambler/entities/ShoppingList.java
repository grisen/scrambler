package com.law.scrambler.entities;

import org.springframework.data.annotation.Id;

public class ShoppingList {

    @Id
    public Long id;

    public String name;

    public String date;

}
