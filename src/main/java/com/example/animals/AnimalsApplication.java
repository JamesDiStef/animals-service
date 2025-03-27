package com.example.animals;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AnimalsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalsApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(MammalRepository repo) {
//        return args -> {

//            List<Mammal> mammals = new ArrayList<Mammal>(
//                    Arrays.asList(
//                            new Mammal("lion", "", "https://en.wikipedia.org/wiki/Lion"),
//                            new Mammal("elephant", "", "https://en.wikipedia.org/wiki/Elephant"),
//                            new Mammal("tiger", "", "https://en.wikipedia.org/wiki/Tiger"),
//                            new Mammal("giraffe", "", "https://en.wikipedia.org/wiki/Giraffe"),
//                            new Mammal("whale", "", "https://en.wikipedia.org/wiki/Whale"),
//                            new Mammal("bat", "", "https://en.wikipedia.org/wiki/Bat"),
//                            new Mammal("kangaroo", "", "https://en.wikipedia.org/wiki/Kangaroo"),
//                            new Mammal("panda", "", "https://en.wikipedia.org/wiki/Panda"),
//                            new Mammal("polar bear", "", "https://en.wikipedia.org/wiki/Polar_bear"),
//                            new Mammal("zebra", "", "https://en.wikipedia.org/wiki/Zebra"),
//                            new Mammal("sloth", "", "https://en.wikipedia.org/wiki/Sloth"),
//                            new Mammal("cheetah", "", "https://en.wikipedia.org/wiki/Cheetah"),
//                            new Mammal("rhinoceros", "", "https://en.wikipedia.org/wiki/Rhinoceros"),
//                            new Mammal("koala", "", "https://en.wikipedia.org/wiki/Koala"),
//                            new Mammal("arctic fox", "", "https://en.wikipedia.org/wiki/Arctic_fox"),
//                            new Mammal("hyena", "", "https://en.wikipedia.org/wiki/Hyena"),
//                            new Mammal("chimpanzee", "", "https://en.wikipedia.org/wiki/Chimpanzee"),
//                            new Mammal("meerkat", "", "https://en.wikipedia.org/wiki/Meerkat"),
//                            new Mammal("otter", "", "https://en.wikipedia.org/wiki/Otter"),
//                            new Mammal("bison", "", "https://en.wikipedia.org/wiki/Bison"),
//                            new Mammal("mole", "", "https://en.wikipedia.org/wiki/Mole"),
//                            new Mammal("jaguar", "", "https://en.wikipedia.org/wiki/Jaguar"),
//                            new Mammal("hippo", "", "https://en.wikipedia.org/wiki/Hippopotamus"),
//                            new Mammal("leopard", "", "https://en.wikipedia.org/wiki/Leopard"),
//                            new Mammal("gorilla", "", "https://en.wikipedia.org/wiki/Gorilla"),
//                            new Mammal("opossum", "", "https://en.wikipedia.org/wiki/Opossum"),
//                            new Mammal("aardvark", "", "https://en.wikipedia.org/wiki/Aardvark"),
//                            new Mammal("wolverine", "", "https://en.wikipedia.org/wiki/Wolverine"),
//                            new Mammal("tasmanian devil", "", "https://en.wikipedia.org/wiki/Tasmanian_devil"),
//                            new Mammal("coyote", "", "https://en.wikipedia.org/wiki/Coyote"),
//                            new Mammal("pangolin", "", "https://en.wikipedia.org/wiki/Pangolin"),
//                            new Mammal("binturong", "", "https://en.wikipedia.org/wiki/Binturong"),
//                            new Mammal("red panda", "", "https://en.wikipedia.org/wiki/Red_panda"),
//                            new Mammal("anteater", "", "https://en.wikipedia.org/wiki/Anteater"),
//                            new Mammal("wild boar", "", "https://en.wikipedia.org/wiki/Wild_boar"),
//                            new Mammal("wombat", "", "https://en.wikipedia.org/wiki/Wombat"),
//                            new Mammal("bat-eared fox", "", "https://en.wikipedia.org/wiki/Bat-eared_fox"),
//                            new Mammal("porcupine", "", "https://en.wikipedia.org/wiki/Porcupine"),
//                            new Mammal("red fox", "", "https://en.wikipedia.org/wiki/Red_fox"),
//                            new Mammal("beaver", "", "https://en.wikipedia.org/wiki/Beaver"),
//                            new Mammal("siberian tiger", "", "https://en.wikipedia.org/wiki/Siberian_tiger"),
//                            new Mammal("raccoon", "", "https://en.wikipedia.org/wiki/Raccoon"),
//                            new Mammal("civets", "", "https://en.wikipedia.org/wiki/Civets"),
//                            new Mammal("dolphin", "", "https://en.wikipedia.org/wiki/Dolphin"),
//                            new Mammal("marmot", "", "https://en.wikipedia.org/wiki/Marmot"),
//                            new Mammal("tapir", "", "https://en.wikipedia.org/wiki/Tapir"),
//                            new Mammal("armadillo", "", "https://en.wikipedia.org/wiki/Armadillo"),
//                            new Mammal("chinchilla", "", "https://en.wikipedia.org/wiki/Chinchilla"),
//                            new Mammal("pygmy hippopotamus", "", "https://en.wikipedia.org/wiki/Pygmy_hippopotamus"),
//                            new Mammal("mountain lion", "", "https://en.wikipedia.org/wiki/Mountain_lion"),
//                            new Mammal("numbat", "", "https://en.wikipedia.org/wiki/Numbat"),
//                            new Mammal("springbok", "", "https://en.wikipedia.org/wiki/Springbok"),
//                            new Mammal("greater kudu", "", "https://en.wikipedia.org/wiki/Greater_kudu"),
//                            new Mammal("okapi", "", "https://en.wikipedia.org/wiki/Okapi"),
//                            new Mammal("black rhinoceros", "", "https://en.wikipedia.org/wiki/Black_rhinoceros"),
//                            new Mammal("echidna", "", "https://en.wikipedia.org/wiki/Echidna"),
//                            new Mammal("muntjac", "", "https://en.wikipedia.org/wiki/Muntjac"),
//                            new Mammal("ibex", "", "https://en.wikipedia.org/wiki/Ibex"),
//                            new Mammal("markhor", "", "https://en.wikipedia.org/wiki/Markhor"),
//                            new Mammal("muskox", "", "https://en.wikipedia.org/wiki/Muskox"),
//                            new Mammal("bearded vulture", "", "https://en.wikipedia.org/wiki/Bearded_vulture"),
//                            new Mammal("snow leopard", "", "https://en.wikipedia.org/wiki/Snow_leopard"),
//                            new Mammal("tamaraw", "", "https://en.wikipedia.org/wiki/Tamaraw"),
//                            new Mammal("wildebeest", "", "https://en.wikipedia.org/wiki/Wildebeest"),
//                            new Mammal("spring hare", "", "https://en.wikipedia.org/wiki/Spring_hare"),
//                            new Mammal("pygmy goat", "", "https://en.wikipedia.org/wiki/Pygmy_goat"),
//                            new Mammal("yellow mongoose", "", "https://en.wikipedia.org/wiki/Yellow_mongoose"),
//                            new Mammal("sifaka", "", "https://en.wikipedia.org/wiki/Sifaka"),
//                            new Mammal("paca", "", "https://en.wikipedia.org/wiki/Paca"),
//                            new Mammal("serval", "", "https://en.wikipedia.org/wiki/Serval"),
//                            new Mammal("zorilla", "", "https://en.wikipedia.org/wiki/Zorilla")
//                    )
//            );
//
//            //usingMongoTemplateAndQuary(repo, mongoTemplate, mammal);
//            mammals.forEach(mammal -> {
//                repo.findMammalBySpecies(mammal.getSpecies()).ifPresentOrElse(s -> {
//                throw new IllegalStateException("should only be one record for each species");
//                    System.out.println("it already exists");
//                }, () -> {
//                    repo.insert(mammal);
//                });
//            });
//
//        };
    //}
}
