package com.law.scrambler.mappers;

import com.law.scrambler.entities.Ingredient;
import com.law.scrambler.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by root on 2017-05-30.
 */
@Service
public class IngredientMapper implements Mapper{

    @Autowired
    private IngredientRepository ingredientRepository;

    public IngredientMapper() {

    }

    public void map(String name) {
        if (ingredientRepository.findByName(name) == null) {
            ingredientRepository.save(new Ingredient(name));
        }


        //System.out.println("INGREDIENTS!!!");

        //ingredientRepository.findAll().forEach(i -> System.out.println(i.name));
    }

}
