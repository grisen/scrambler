package com.law.scrambler.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Unit {
    @Id
    public String id;

    @Indexed
    public String name;

    public Unit(String name) {
        this.name = name;

    }
}
