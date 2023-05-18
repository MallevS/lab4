package mk.ukim.finki.emt.delivery.services.forms;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.delivery.domain.model.DeliveryType;
import mk.ukim.finki.emt.delivery.domain.valueobjects.Client;
import mk.ukim.finki.emt.delivery.domain.model.DeliveryState;
import java.util.Set;

@Data
public class DeliveryForm {
    @NotNull
    private DeliveryState state;
    @NotNull
    private DeliveryType type;
    @NotNull
    private Client client;
    @NotEmpty
    @Valid
    private Set<DeliveryItemForm> items;
}
