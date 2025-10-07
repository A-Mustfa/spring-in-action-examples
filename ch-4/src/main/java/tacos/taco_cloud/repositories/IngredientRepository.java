package tacos.taco_cloud.repositories;

import org.springframework.data.repository.CrudRepository;

import tacos.taco_cloud.domains.Ingredients;


public interface IngredientRepository extends CrudRepository<Ingredients,String>{

}
