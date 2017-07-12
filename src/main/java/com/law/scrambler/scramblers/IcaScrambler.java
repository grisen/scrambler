package com.law.scrambler.scramblers;

import com.law.scrambler.dtos.RecepieDTO;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by root on 2017-07-12.
 */
public class IcaScrambler extends MainScrambler {

    private static String begin= "<h2>Ingredienser</h2>";

    @Override
    public RecepieDTO processRecepie(String recepieUrl) {
        Elements elements = getElements(recepieUrl, begin);

        List quantitys = getQuantitys(elements);
        List units = getUnits(elements);
        List ingredients = getIngredients(elements);

        return new RecepieDTO(ingredients, quantitys, units);
    }

    @Override
    protected List getIngredients(Elements elements) {
        ingredientList = new ArrayList();
        elements.select(".ingredient").forEach(i-> {

            String collect = Pattern.compile(" ").splitAsStream(i.text())
                    .filter(s -> !Character.isDigit(s.charAt(0)) && !unitList.contains(s))
                    .collect(Collectors.joining(" "));

            ingredientList.add(collect);
        });

        return ingredientList;
    }

    @Override
    protected List getUnits(Elements elements) {
        unitList = new ArrayList();
        elements.select(".ingredient").forEach(i ->  {
            String attr = i.attr("data-type");
            if (!attr.isEmpty()) {
                unitList.add(attr);
            }
        });
        return unitList;
    }

    @Override
    protected List getQuantitys(Elements elements) {
        quantityList = new ArrayList();
        elements.select(".ingredient").forEach(i ->  {
            String attr = i.attr("data-amount");
            if (!attr.isEmpty()) {
                quantityList.add(attr);
            }
        });
        return quantityList;
    }

    @Override
    public void getRecepieById(Long id) {

    }
}
