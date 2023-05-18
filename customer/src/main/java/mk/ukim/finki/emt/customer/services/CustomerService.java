package mk.ukim.finki.emt.customer.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.emt.customer.domain.exceptions.ClientNotFoundException;
import mk.ukim.finki.emt.customer.domain.model.Customer;
import mk.ukim.finki.emt.customer.domain.model.CustomerId;
import mk.ukim.finki.emt.customer.domain.repository.CustomerRepository;
import mk.ukim.finki.emt.customer.services.forms.CustomerForm;
import org.springframework.stereotype.Service;

import jakarta.validation.Validator;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CustomerService implements ICustomerService{
    private final CustomerRepository customerRepository;
    private final Validator validator;

    @Override
    public Customer findById(@NonNull CustomerId id) {
        return customerRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id.getId()));
    }

    @Override
    public CustomerId createCustomer(@NonNull CustomerForm customer) {
        var violations = validator.validate(customer);

        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Invalid client data");
        }

        var c = new Customer(customer.getName(), customer.getAddress(), customer.getEmail(), customer.getPhone());

        return customerRepository.saveAndFlush(c).getId();
    }

    @Override
    public Customer updateCustomer(@NonNull CustomerId clientId, @NonNull CustomerForm customer) {
        var c = findById(clientId);

        c.updateCustomer(customer.getName(), customer.getAddress(), customer.getEmail(), customer.getPhone());

        return customerRepository.saveAndFlush(c);
    }

    @Override
    public void deleteCustomer(@NonNull CustomerId customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> listAll() {
        return customerRepository.findAll();
    }
}
