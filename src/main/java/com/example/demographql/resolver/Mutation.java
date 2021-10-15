package com.example.demographql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demographql.entity.Dog;
import com.example.demographql.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private final DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        for (Dog dog : dogRepository.findAll()) {
            if (dog.getBreed().equals(breed)) {
                dogRepository.delete(dog);
                deleted = true;
            }
        }
        if (!deleted) {
            throw new BreedNotFoundException(breed);
        }
        return true;
    }

    public Dog updateDogName(String newName, Long id) {
        Dog dog = dogRepository.findById(id).orElseThrow(() -> new DogNotFoundException(id));
        dog.setName(newName);
        dogRepository.save(dog);
        return dog;
    }

}
