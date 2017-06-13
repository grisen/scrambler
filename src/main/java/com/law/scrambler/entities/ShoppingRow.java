package com.law.scrambler.entities;

import org.springframework.data.annotation.Id;

public class ShoppingRow {

    @Id
    public String id;

    public String ingredientId;

    public String quantityId;

    public String unitId;

    public String recipeId;

}
