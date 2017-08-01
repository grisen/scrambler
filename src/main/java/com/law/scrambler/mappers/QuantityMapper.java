package com.law.scrambler.mappers;


import com.law.scrambler.entities.Quantity;
import com.law.scrambler.repositories.QuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class QuantityMapper extends Mapper {

    @Autowired
    QuantityRepository quantityRepository;

    @Override
    public void map(String quantity) {
        if (quantityRepository.findByName(quantity) == null) {
            quantityRepository.save(new Quantity(quantity));
        }
    }

    @Override
    void mapQuantity(String quantity) {

    }

    @Override
    void mapUnit(String unit) {

    }

}
