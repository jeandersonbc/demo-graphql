package com.example.demographql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demographql.entity.Dog;
import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {

    public Boolean deleteDogBreed(String breed) {
        // TODO
        return false;
    }

    public Optional<Dog> updateDogName(String newName, Long id) {
        // TODO
        return Optional.empty();
    }

}
