package mk.ukim.finki.emt.restaurant.domain.model;

import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

public class RestaurantId extends DomainObjectId {
    public RestaurantId() {
        super(DomainObjectId.randomId(RestaurantId.class).getId());
    }

    public RestaurantId(String id) {
        super(id);
    }
}
