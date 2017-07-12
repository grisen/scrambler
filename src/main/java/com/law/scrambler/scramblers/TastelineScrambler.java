package com.law.scrambler.scramblers;

import com.law.scrambler.URLHandler;
import com.law.scrambler.dtos.RecepieDTO;
import com.law.scrambler.mappers.IngredientMapper;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TastelineScrambler extends MainScrambler {

    private static String begin= "div[class=\"ingredient-group\"]";

    @Override
    public RecepieDTO processRecepie(String recepieUrl) {
        Elements elements = getElements(recepieUrl, begin);

        List ingredients = getIngredients(elements);
        List quantitys = getQuantitys(elements);
        List units = getUnits(elements);

        return new RecepieDTO(ingredients, quantitys, units);
    }

    protected List getIngredients(Elements elements) {

        ingredientList = new ArrayList();
        elements.select(".ingredient").forEach(i-> ingredientList.add(i.text()));

        return ingredientList;
    }

    protected List getUnits(Elements elements) {

        unitList = new ArrayList();
        elements.select(".unit").forEach(i-> unitList.add(i.text()));

        return unitList;
    }

    protected List getQuantitys(Elements elements) {

        quantityList = new ArrayList();
        elements.select(".quantity").forEach(i-> quantityList.add(i.text()));

        return quantityList;
    }

    @Override
    public void getRecepieById(Long id) {

    }
}
