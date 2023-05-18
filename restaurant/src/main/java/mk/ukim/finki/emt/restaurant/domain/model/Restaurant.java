package mk.ukim.finki.emt.restaurant.domain.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import mk.ukim.finki.emt.restaurant.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.financial.Money;

import java.util.Objects;


@Entity
@Getter
public class Restaurant extends AbstractEntity<RestaurantId> {
    private String name;
    private Quantity quantity;
    private Money price;

    protected Restaurant() {
        super(DomainObjectId.randomId(RestaurantId.class));
    }

    public Restaurant(String name, Quantity quantity, Money price) {
        super(DomainObjectId.randomId(RestaurantId.class));
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void updateRestaurant(String name, Quantity quantity, Money price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void addQuantity() {
        quantity = quantity.add();
    }

    public void subtractQuantity() {
        quantity = quantity.subtract();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Restaurant restaurant = (Restaurant) o;
        return Objects.equals(name, restaurant.name) && Objects.equals(quantity, restaurant.quantity) && Objects.equals(price, restaurant.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, quantity, price);
    }
}
