package com.example.animals;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MammalService {
    private final MammalRepository mammalRepository;
    public List<Mammal> getAllMammals() {
        return mammalRepository.findAll();
    }

    public Optional<Mammal> getMammalBySpecies(String species) {
        species = species.toLowerCase();
        return mammalRepository.findMammalBySpecies(species);
    }

    public void addMammal(Mammal mammal) {
        mammalRepository.insert(mammal);
    }

    public Mammal updateDescription(String species, String newDescription) {
        Optional<Mammal> optionalMammal = mammalRepository.findMammalBySpecies(species);

        if (optionalMammal.isPresent()) {
            Mammal mammal = optionalMammal.get();
            mammal.setDescription(newDescription);
            return mammalRepository.save(mammal);  // Save the updated mammal
        } else {
            throw new RuntimeException("Mammal not found for species: " + species);  // Or handle this error properly
        }
    }
}
