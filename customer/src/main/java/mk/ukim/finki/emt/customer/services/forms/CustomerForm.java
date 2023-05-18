package mk.ukim.finki.emt.customer.services.forms;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.address.Address;

@Data
public class CustomerForm {
    @NotNull
    public String name;
    @NotNull
    public Address address;
    @NotNull
    public String email;
    @NotNull
    public String phone;
}
