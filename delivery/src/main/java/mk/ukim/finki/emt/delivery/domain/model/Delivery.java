package mk.ukim.finki.emt.delivery.domain.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.delivery.domain.valueobjects.Client;
import mk.ukim.finki.emt.delivery.domain.valueobjects.Product;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "deliverys")
@Getter
public class Delivery extends AbstractEntity<DeliveryId> {
    private Instant timestamp;
    @Enumerated(EnumType.STRING)
    private DeliveryState state;
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryItem;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DeliveryItem> items;
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "customer_id", nullable = false)
            ))
    private Client client;

    public Delivery() {
        super(DomainObjectId.randomId(DeliveryId.class));
        this.items = new HashSet<>();
    }

    public Delivery(Instant timestamp, DeliveryState state, DeliveryType deliveryItem, Client client) {
        super(DomainObjectId.randomId(DeliveryId.class));
        this.timestamp = timestamp;
        this.state = state;
        this.deliveryItem = deliveryItem;
        this.items = new HashSet<>();
        this.client = client;
    }

    public void changeState(DeliveryState state) {
        this.state = state;
    }

    public void addItem(@NonNull Product product, int quantity) {
        items.add(new DeliveryItem(quantity, product.getId()));
        //product.getPrice(),
    }

    public void removeItem(@NonNull DeliveryItemId id) {
        items.removeIf(i -> i.getId().equals(id));
    }

//    public Money total() {
//        return items.stream().map(OrderItem::subtotal).reduce(new Money(currency, 0), Money::add);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(timestamp, delivery.timestamp) && state == delivery.state && deliveryItem == delivery.deliveryItem && Objects.equals(items, delivery.items) && Objects.equals(client, delivery.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), timestamp, state, deliveryItem, items, client);
    }
}
