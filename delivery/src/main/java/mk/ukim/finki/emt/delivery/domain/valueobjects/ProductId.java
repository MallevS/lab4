package mk.ukim.finki.emt.delivery.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

public class ProductId extends DomainObjectId {
    public ProductId() {
        super(DomainObjectId.randomId(ProductId.class).getId());
    }

    public ProductId(String id) {
        super(id);
    }
}