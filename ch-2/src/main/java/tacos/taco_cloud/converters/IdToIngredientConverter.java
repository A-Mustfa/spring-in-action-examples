package tacos.taco_cloud.converters;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.taco_cloud.domains.Ingredients;
import tacos.taco_cloud.domains.Ingredients.Type;

@Component
public class IdToIngredientConverter implements Converter<String, Ingredients> {

    Map<String,Ingredients> ingredientMap = new HashMap<>();
    

    public IdToIngredientConverter(){
        ingredientMap.put("FLTO", 
            new Ingredients("FLTO", "Flour Tortilla", Type.WRAP));
        ingredientMap.put("COTO", 
            new Ingredients("COTO", "Corn Tortilla", Type.WRAP));
        ingredientMap.put("GRBF", 
            new Ingredients("GRBF", "Ground Beef", Type.PROTEIN));
        ingredientMap.put("CARN", 
            new Ingredients("CARN", "Carnitas", Type.PROTEIN));
        ingredientMap.put("TMTO", 
            new Ingredients("TMTO", "Diced Tomatoes", Type.VEGGIES));
        ingredientMap.put("LETC", 
            new Ingredients("LETC", "Lettuce", Type.VEGGIES));
        ingredientMap.put("CHED", 
            new Ingredients("CHED", "Cheddar", Type.CHEESE));
        ingredientMap.put("JACK", 
            new Ingredients("JACK", "Monterrey Jack", Type.CHEESE));
        ingredientMap.put("SLSA", 
            new Ingredients("SLSA", "Salsa", Type.SAUSE));
        ingredientMap.put("SRCR", 
            new Ingredients("SRCR", "Sour Cream", Type.SAUSE));
            }

    @Override
    public Ingredients convert(String id) {
        return ingredientMap.get(id);
    }


}
