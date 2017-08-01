package com.law.scrambler.mappers;

import com.law.scrambler.entities.Ingredient;
import com.law.scrambler.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class IngredientMapper extends Mapper{

    @Autowired
    private IngredientRepository ingredientRepository;

    public IngredientMapper() {

    }

    @Override
    public void map(String ingredient) {
        if (ingredientRepository.findByName(ingredient) == null) {
            ingredientRepository.save(new Ingredient(ingredient));
        }
    }

    @Override
    void mapQuantity(String quantity) {

    }

    @Override
    void mapUnit(String unit) {

    }

}
