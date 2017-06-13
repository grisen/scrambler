package com.law.scrambler.scramblers;

import com.law.scrambler.URLHandler;
import com.law.scrambler.mappers.IngredientMapper;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by root on 2017-05-30.
 */
public class TastelineScrambler implements MainScrambler {

    @Autowired
    IngredientMapper ingredientMapper;

    @Override
    public void saveRecepie(String recepieUrl) {
        Elements elements = URLHandler.invoke(recepieUrl);

        elements.select(".ingredient").forEach(i-> ingredientMapper.map(i.text()));
        elements.select(".quantity").forEach(i-> ingredientMapper.map(i.text()));
        elements.select(".unit").forEach(i-> ingredientMapper.map(i.text()));
    }

    @Override
    public void getRecepieById(Long id) {

    }
}
