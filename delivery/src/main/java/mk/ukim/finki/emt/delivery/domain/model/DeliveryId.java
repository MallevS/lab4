package mk.ukim.finki.emt.delivery.domain.model;

import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

public class DeliveryId extends DomainObjectId {
    public DeliveryId() {
        super(DomainObjectId.randomId(DeliveryId.class).getId());
    }

    public DeliveryId(String id) {
        super(id);
    }
}
