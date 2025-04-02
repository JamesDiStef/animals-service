package com.example.animals;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/entries")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "https://rococo-lokum-be94cf.netlify.app/", "https://encyclopedia-j.netlify.app/"})
public class EntryController {
    private final EntryService entryService;

    @GetMapping
    public List<Entry> fetchAllEntries(){
        return entryService.getAllEntries();
    }

    @GetMapping("/{topic}")
    public Optional<Entry> fetchEntryByTopic(@PathVariable String topic){
        topic = topic.toLowerCase();
        return entryService.getEntryByTopic(topic);
    }

    @PostMapping("/entry")
    public void addEntry(@RequestBody Entry entry){
        entry.setTopic(entry.getTopic().toLowerCase());
        entryService.addEntry(entry);
    }

    @PatchMapping("/{topic}")
    public Entry updateEntryDescription(@PathVariable String topic, @RequestBody Entry entry) {
        topic = topic.toLowerCase();  // Convert to lowercase or handle as per your requirement
        return entryService.updateDescription(topic, entry.getDescription());
    }
}
