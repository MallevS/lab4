package mk.ukim.finki.emt.customer.port;


import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.customer.domain.model.Customer;
import mk.ukim.finki.emt.customer.domain.model.CustomerId;
import mk.ukim.finki.emt.customer.services.ICustomerService;
import mk.ukim.finki.emt.customer.services.forms.CustomerForm;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerResource {
    private final ICustomerService customerService;

    @GetMapping
    public List<Customer> listAll() {
        return customerService.listAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") CustomerId id) {
        return customerService.findById(id);
    }

    @PostMapping("/create")
    public void createCustomer(@RequestBody CustomerForm customer, HttpServletResponse response) throws IOException {
        customerService.createCustomer(customer);
        response.sendRedirect("/api/customers");
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable("id") CustomerId customerId, @RequestBody CustomerForm customer, HttpServletResponse response) throws IOException {
        customerService.updateCustomer(customerId, customer);
        response.sendRedirect("/api/customers");
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") CustomerId customerId, HttpServletResponse response) throws IOException {
        customerService.deleteCustomer(customerId);
        response.sendRedirect("/api/customers");
    }
}
