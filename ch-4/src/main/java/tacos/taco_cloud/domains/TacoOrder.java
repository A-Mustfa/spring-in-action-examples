package tacos.taco_cloud.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private Date placedAt = new Date();


    @NotBlank(message="you must provide a value")
    private String deliveryName;

    @NotBlank(message="Street is required")
    private String deliveryStreet;

     @NotBlank(message="City is required")
    private String deliveryCity;

     @NotBlank(message="delivery state is required")
    private String deliveryState;

     @NotBlank(message="Zip is required")
    private String deliveryZip;

     @CreditCardNumber
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="invalid cvv")
    private String ccCVV;

    @OneToMany(cascade = CascadeType.ALL )
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
    this.tacos.add(taco);
    }
}
