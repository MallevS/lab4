package mk.ukim.finki.emt.customer.services;

import mk.ukim.finki.emt.customer.domain.model.Customer;
import mk.ukim.finki.emt.customer.domain.model.CustomerId;
import mk.ukim.finki.emt.customer.services.forms.CustomerForm;

import java.util.List;

public interface ICustomerService {
    Customer findById(CustomerId id);

    CustomerId createCustomer(CustomerForm customer);

    Customer updateCustomer(CustomerId customerId, CustomerForm customer);

    void deleteCustomer(CustomerId customerId);

    List<Customer> listAll();
}
