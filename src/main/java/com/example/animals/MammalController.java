package com.example.animals;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/mammals")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class MammalController {
    private final MammalService mammalService;

    @GetMapping
    public List<Mammal> fetchAllMammals(){
        return mammalService.getAllMammals();
    }

    @GetMapping("/{species}")
    public Optional<Mammal> fetchMammalBySpecies(@PathVariable String species){
        species = species.toLowerCase();
        return mammalService.getMammalBySpecies(species);
    }
}
