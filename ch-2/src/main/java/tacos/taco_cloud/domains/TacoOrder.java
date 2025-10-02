package tacos.taco_cloud.domains;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TacoOrder {


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
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
    this.tacos.add(taco);
    }
}
