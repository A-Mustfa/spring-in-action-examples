package tacos.taco_cloud.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tacos.taco_cloud.domains.Ingredients;


public interface IngredientRepository extends CrudRepository<Ingredients,String>{

}
