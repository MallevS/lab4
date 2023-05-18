package mk.ukim.finki.emt.customer.domain.repository;

import mk.ukim.finki.emt.customer.domain.model.Customer;
import mk.ukim.finki.emt.customer.domain.model.CustomerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {
}
