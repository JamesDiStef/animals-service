package com.example.animals;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class AnimalsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalsApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(MammalRepository repo) {
        return args -> {
            Mammal mammal = new Mammal("dinosaur", "not a mammal","www");
            //usingMongoTemplateAndQuary(repo, mongoTemplate, mammal);
            repo.findMammalBySpecies("dinosaur").ifPresentOrElse(s -> {
//                throw new IllegalStateException("should only be one record for each species");
                System.out.println("it already exists");
            }, () -> {
                repo.insert(mammal);
            });
        };
    }

    private static void usingMongoTemplateAndQuary(MammalRepository repo, MongoTemplate mongoTemplate, Mammal mammal) {
        Query query = new Query();
        query.addCriteria(Criteria.where("species").is("dinosuar"));
        List<Mammal> mammals = mongoTemplate.find(query, Mammal.class);
        if(mammals.size() > 1) throw new IllegalStateException("should only be one record for each species");
        if(mammals.isEmpty()) repo.insert(mammal);
    }
}
