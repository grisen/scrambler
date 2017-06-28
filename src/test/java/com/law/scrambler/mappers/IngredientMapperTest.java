package com.law.scrambler.mappers;

import com.law.scrambler.entities.Ingredient;
import com.law.scrambler.repositories.IngredientRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IngredientMapperTest {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private IngredientMapper ingredientMapper;

    @Test
    public void map() throws Exception {
        Ingredient ingredient = new Ingredient("test");

        ingredientMapper.mapIngredient(ingredient.name);
        ingredientMapper.mapIngredient(ingredient.name);

        List list = (List<Ingredient>)ingredientRepository.findAllByName(ingredient.name);

        Assert.assertEquals(1, list.size());
    }

}