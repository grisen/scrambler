package com.law.scrambler.mappers;

public abstract class Mapper
{

    public abstract void map(String ingredient);
    abstract void mapQuantity(String quantity);
    abstract void mapUnit(String unit);

}
