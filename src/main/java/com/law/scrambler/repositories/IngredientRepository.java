package com.law.scrambler.repositories;

import com.law.scrambler.entities.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {

    public Ingredient findByName(String name);

    public List<Ingredient> findAllByName(String name);

}
