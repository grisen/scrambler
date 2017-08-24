package com.law.scrambler.entities;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class ShoppingRow {

    @Id
    public Long id;

    public ArrayList ingredients;

    public ArrayList quantitys;

    public ArrayList units;

    public Long recipeId;

}
