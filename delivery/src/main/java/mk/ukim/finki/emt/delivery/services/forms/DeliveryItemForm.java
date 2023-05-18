package mk.ukim.finki.emt.delivery.services.forms;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.delivery.domain.valueobjects.Product;

@Data
public class DeliveryItemForm {
    @NotNull
    private Product product;
    @NotNull
    @Min(1)
    private Integer quantity;
}
