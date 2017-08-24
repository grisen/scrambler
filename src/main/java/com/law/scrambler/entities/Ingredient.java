package com.law.scrambler.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Ingredient {

    @Id
    public Long id;

    @Indexed
    public String name;

    public Ingredient (String name) {
        this.name = name;
    }
}