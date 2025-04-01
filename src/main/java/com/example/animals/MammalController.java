package com.example.animals;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/mammals")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "https://rococo-lokum-be94cf.netlify.app/"})
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

    @PostMapping("/mammal")
    public void addMammal(@RequestBody Mammal mammal){
        System.out.println(mammal);
        mammalService.addMammal(mammal);
    }

    @PatchMapping("/{speciesName}")
    public Mammal updateMammalDescription(@PathVariable String speciesName, @RequestBody Mammal mammal) {
        speciesName = speciesName.toLowerCase();  // Convert to lowercase or handle as per your requirement
        return mammalService.updateDescription(speciesName, mammal.getDescription());
    }

}
