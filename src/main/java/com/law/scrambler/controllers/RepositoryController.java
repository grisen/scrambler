package com.law.scrambler.controllers;

import com.law.scrambler.dtos.RecepieDTO;
import com.law.scrambler.entities.Ingredient;
import com.law.scrambler.entities.Quantity;
import com.law.scrambler.entities.Unit;
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
        dto.ingredients.forEach(i -> ingredientRepository.save(new Ingredient(i)));
        dto.units.forEach(u -> unitRepository.save(new Unit(u)));
        dto.quantitys.forEach(q -> new Quantity(q));



    };

}
