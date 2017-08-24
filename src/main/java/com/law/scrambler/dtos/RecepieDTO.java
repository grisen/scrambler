package com.law.scrambler.dtos;

import java.util.ArrayList;
import java.util.List;

public class RecepieDTO {

    public RecepieDTO(ArrayList<String> ingredients, ArrayList<String> quantitys, ArrayList<String> units){
        this.ingredients = ingredients;
        this.quantitys = quantitys;
        this.units = units;
    }


    public Long id;
    public ArrayList<String> ingredients;
    public ArrayList<String> quantitys;
    public ArrayList<String> units;
    public Long recipeId;

}
