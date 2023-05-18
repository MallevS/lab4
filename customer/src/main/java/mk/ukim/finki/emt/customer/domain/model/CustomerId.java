package mk.ukim.finki.emt.customer.domain.model;

import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

public class CustomerId extends DomainObjectId {
    public CustomerId() {
        super(DomainObjectId.randomId(CustomerId.class).getId());
    }

    public CustomerId(String id) {
        super(id);
    }
}
