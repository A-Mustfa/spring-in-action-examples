package tacos.taco_cloud.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.taco_cloud.JDBC.JDBCIngredientRepository;
import tacos.taco_cloud.domains.Ingredients;

@Component
public class IdToIngredientConverter implements Converter<String, Ingredients> {

   private JDBCIngredientRepository repo;

    public IdToIngredientConverter(JDBCIngredientRepository repo) {
        this.repo = repo;
    }



    @Override
    public Ingredients convert(String id) {
        return repo.findById(id).orElse(null);
    }


}
