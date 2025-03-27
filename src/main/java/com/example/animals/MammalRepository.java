package com.example.animals;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MammalRepository  extends MongoRepository<Mammal, String> {
    Optional<Mammal> findMammalBySpecies(String species);
}
