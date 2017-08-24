package com.law.scrambler.controllers;

import com.law.scrambler.dtos.RecepieDTO;
import com.law.scrambler.entities.*;
import com.law.scrambler.repositories.IngredientRepository;
import com.law.scrambler.repositories.QuantityRepository;
import com.law.scrambler.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RepositoryController {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    UnitRepository unitRepository;

    @Autowired
    QuantityRepository quantityRepository;


    public void saveReceipe(RecepieDTO dto) {
        ShoppingList shoppingList = new ShoppingList();
        ShoppingRow shoppingRow = new ShoppingRow();


        dto.ingredients.forEach(i -> {
            Ingredient ingredient = ingredientRepository.save(new Ingredient(i));
            shoppingRow.ingredients.add(ingredient.id);
        });


        dto.units.forEach(u -> {
            Unit save = unitRepository.save(new Unit(u));
            shoppingRow.units.add(save.id);

        });
        dto.quantitys.forEach(q -> {
            Quantity save = quantityRepository.save(new Quantity(q));
            shoppingRow.quantitys.add(save.id);
        });



    };

}
