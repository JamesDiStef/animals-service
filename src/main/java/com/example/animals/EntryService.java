package com.example.animals;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EntryService {
    private final EntryRepository entryRepository;
    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }

    public Optional<Entry> getEntryByTopic(String topic) {
        topic = topic.toLowerCase();
        return entryRepository.findEntryByTopic(topic);
    }

    public void addEntry(Entry entry) {
        entryRepository.insert(entry);
    }

    public Entry updateDescription(String topic, String newDescription) {
        Optional<Entry> optionalEntry = entryRepository.findEntryByTopic(topic);

        if (optionalEntry.isPresent()) {
            Entry entry = optionalEntry.get();
            entry.setDescription(newDescription);
            return entryRepository.save(entry);  // Save the updated mammal
        } else {
            throw new RuntimeException("Entry not found for species: " + topic);  // Or handle this error properly
        }
    }
}
