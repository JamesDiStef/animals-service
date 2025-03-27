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
}
