package tacos.taco_cloud.domains;

import java.util.Date;
import java.util.List;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id; 

    private Date CreatedAt = new Date();


    @NotNull
    @Size(min=5,message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "you had to select at least 1 ingredient")
    @ManyToMany
    private List<Ingredients> ingredients;
   

}
