package mk.ukim.finki.emt.delivery.domain.model;

import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

public class DeliveryItemId extends DomainObjectId {
    public DeliveryItemId() {
        super(DomainObjectId.randomId(DeliveryItemId.class).getId());
    }

    public DeliveryItemId(String id) {
        super(id);
    }
}
