package com.example.animals;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
