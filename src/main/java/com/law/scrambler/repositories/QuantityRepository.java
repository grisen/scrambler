package com.law.scrambler.repositories;

import com.law.scrambler.entities.Ingredient;
import com.law.scrambler.entities.Quantity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuantityRepository extends MongoRepository<Quantity, String> {

    public Quantity findByName(String name);

    public List<Quantity> findAllByName(String name);

}
