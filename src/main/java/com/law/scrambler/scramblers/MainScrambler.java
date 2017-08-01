package com.law.scrambler.scramblers;

import com.law.scrambler.URLHandler;
import com.law.scrambler.dtos.RecepieDTO;
import com.law.scrambler.mappers.Mapper;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public abstract class MainScrambler {

    @Autowired
    Mapper mapper;

    protected List quantityList = new ArrayList();
    protected List unitList = new ArrayList();
    protected List ingredientList = new ArrayList();

    protected final String reservedWords = "port, och";


    public Elements getElements(String recepieUrl, String begin) {
        return URLHandler.invoke(recepieUrl, begin);
    };


    protected void mapAndSave(RecepieDTO dto) {
        dto.ingredients.forEach(i -> mapper.map(i.toLowerCase()));

    };

    protected String wash(Element i) {
        return Pattern.compile(" ").splitAsStream(i.text())
                .filter(s -> !Character.isDigit(s.charAt(0)) && !unitList.contains(s) && !reservedWords.contains(s))
                .collect(Collectors.joining(" "));
    }


    public abstract RecepieDTO processRecepie(String recepieUrl);

    protected abstract List getIngredients(Elements elements);
    protected abstract List getUnits(Elements elements);
    protected abstract List getQuantitys(Elements elements);
    public abstract void getRecepieById(Long id);

}
