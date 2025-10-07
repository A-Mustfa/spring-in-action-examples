package tacos.taco_cloud.converters;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.taco_cloud.domains.Ingredients;
import tacos.taco_cloud.repositories.IngredientRepository;

@Component
public class IdToIngredientConverter implements Converter<String, Ingredients> {

   private IngredientRepository repo;

    public IdToIngredientConverter(IngredientRepository repo) {
        this.repo = repo;
    }



    @Override
    public Ingredients convert(String id) {
        return repo.findById(id).orElse(null);
    }


}
