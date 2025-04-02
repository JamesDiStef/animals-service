package com.example.animals;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EntryRepository extends MongoRepository<Entry, String> {
    Optional<Entry> findEntryByTopic(String topic);
}
