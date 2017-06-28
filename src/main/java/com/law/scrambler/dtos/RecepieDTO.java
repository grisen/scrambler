package com.law.scrambler.dtos;

import java.util.List;

public class RecepieDTO {

    public RecepieDTO(List<String> ingredients, List<String> quantitys, List<String> units){
        this.ingredients = ingredients;
        this.quantitys = quantitys;
        this.units = units;
    }

    public List<String> ingredients;
    public List<String> quantitys;
    public List<String> units;


}
