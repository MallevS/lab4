package mk.ukim.finki.emt.restaurant.services.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.restaurant.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.financial.Money;

@Data
public class RestaurantForm {
    @NotNull
    private String name;
    @NotNull
    private Quantity quantity;
    @NotNull
    private Money price;
}
