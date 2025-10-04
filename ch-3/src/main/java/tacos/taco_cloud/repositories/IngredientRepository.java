package tacos.taco_cloud.repositories;

import java.util.Optional;

import tacos.taco_cloud.domains.Ingredients;


public interface IngredientRepository {

    Iterable<Ingredients> findAll();

    Optional<Ingredients> findById(String id);

    Ingredients save(Ingredients ingredient);
}
