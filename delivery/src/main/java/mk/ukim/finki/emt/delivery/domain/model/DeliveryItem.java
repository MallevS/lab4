package mk.ukim.finki.emt.delivery.domain.model;


import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.delivery.domain.valueobjects.ProductId;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

import java.util.Objects;

@Entity
@Getter
public class DeliveryItem extends AbstractEntity<DeliveryItemId> {
    private Integer quantity;
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @jakarta.persistence.Column(name = "product_id", nullable = false))
    )
    private ProductId productId;

    public DeliveryItem() {
        super(DomainObjectId.randomId(DeliveryItemId.class));
    }
    //@NonNull Money price,
    public DeliveryItem( @NonNull Integer quantity, @NonNull ProductId productId) {
        super(DomainObjectId.randomId(DeliveryItemId.class));
        this.quantity = quantity;
        this.productId = productId;
    }

///    public Money subtotal() {
//        return price.multiply(quantity);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeliveryItem orderItem = (DeliveryItem) o;
        return  Objects.equals(quantity, orderItem.quantity) && Objects.equals(productId, orderItem.productId);
    } //Objects.equals(price, orderItem.price) &&

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity, productId);
    }
}
