package com.example.animals;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Entry {
    @Id
    private String id;
    @Indexed(unique = true)
    private String topic;
    private String description;
    private String wiki;

    public Entry(String topic, String description, String wiki) {
        this.topic = topic;
        this.description = description;
        this.wiki = wiki;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }
}
