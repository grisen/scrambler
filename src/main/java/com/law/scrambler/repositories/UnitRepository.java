package com.law.scrambler.repositories;

import com.law.scrambler.entities.Ingredient;
import com.law.scrambler.entities.Unit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UnitRepository extends MongoRepository<Unit, String> {

    public Unit findByName(String name);

    public List<Unit> findAllByName(String name);

}
