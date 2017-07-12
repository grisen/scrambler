package com.law.scrambler.scramblers;

import com.law.scrambler.URLHandler;
import com.law.scrambler.dtos.RecepieDTO;
import com.law.scrambler.mappers.Mapper;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public abstract class MainScrambler {

    @Autowired
    Mapper mapper;

    protected List quantityList = new ArrayList();
    protected List unitList = new ArrayList();
    protected List ingredientList = new ArrayList();

    public Elements getElements(String recepieUrl, String begin) {
        return URLHandler.invoke(recepieUrl, begin);
    };


    protected void mapAndSave(RecepieDTO dto) {
        dto.ingredients.forEach(i -> mapper.mapIngredient(i.toLowerCase()));

    };


    public abstract RecepieDTO processRecepie(String recepieUrl);

    protected abstract List getIngredients(Elements elements);
    protected abstract List getUnits(Elements elements);
    protected abstract List getQuantitys(Elements elements);
    public abstract void getRecepieById(Long id);

}
