package mk.ukim.finki.emt.delivery.services;

import mk.ukim.finki.emt.delivery.domain.model.Delivery;
import mk.ukim.finki.emt.delivery.domain.model.DeliveryId;
import mk.ukim.finki.emt.delivery.domain.valueobjects.Product;
import mk.ukim.finki.emt.delivery.services.forms.DeliveryForm;
import mk.ukim.finki.emt.delivery.domain.model.DeliveryItemId;


import java.util.List;

public interface IDeliveryService {
    Delivery findById(DeliveryId id);

    DeliveryId placeDelivery(DeliveryForm delivery);

    void cancelDelivery(DeliveryId id);

    void addItem(DeliveryId id, Product product, Integer quantity);

    void removeItem(DeliveryId id, DeliveryItemId item);

    List<Delivery> listAll();
}
