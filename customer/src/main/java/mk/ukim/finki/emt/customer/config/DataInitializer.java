package mk.ukim.finki.emt.customer.config;


import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.customer.domain.model.Customer;
import mk.ukim.finki.emt.customer.domain.repository.CustomerRepository;
import mk.ukim.finki.emt.sharedkernel.address.Address;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final CustomerRepository customerRepository;

    @PostConstruct
    public void init() {
        if (customerRepository.count() == 0) {
            customerRepository.saveAndFlush(new Customer("Client 1", new Address("Street 1", "1", "City 1", "Country 1"), "mail@mail.com", "123456789"));
        }
    }
}
