package mk.ukim.finki.emt.delivery.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

public class ClientId extends DomainObjectId {
    public ClientId() {
        super(DomainObjectId.randomId(ClientId.class).getId());
    }

    public ClientId(String id) {
        super(id);
    }
}
