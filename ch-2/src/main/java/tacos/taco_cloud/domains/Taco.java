package tacos.taco_cloud.domains;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {


    @NotNull
    @Size(min=5,message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "you had to select at least 1 ingredient")
    private List<Ingredients> ingredients;
   

}
