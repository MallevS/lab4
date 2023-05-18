package mk.ukim.finki.emt.customer.domain.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.address.Address;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;


import java.util.Objects;

@Entity
@Getter
public class Customer extends AbstractEntity<CustomerId> {
    private String name;
    private Address address;
    private String email;
    private String phone;

    public Customer() {
        super(DomainObjectId.randomId(CustomerId.class));
    }

    public Customer(String name, Address address, String email, String phone) {
        super(DomainObjectId.randomId(CustomerId.class));
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public void updateCustomer(String name, Address address, String email, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(address, customer.address) && Objects.equals(email, customer.email) && Objects.equals(phone, customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, address, email, phone);
    }
}
