package com.example.demographql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demographql.entity.Dog;
import com.example.demographql.repository.DogRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private final DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        return optionalDog.orElseThrow(() -> new DogNotFoundException(id));
    }
}
