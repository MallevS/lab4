package mk.ukim.finki.emt.delivery.services;


import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.emt.delivery.domain.exceptions.DeliveryNotFoundException;
import mk.ukim.finki.emt.delivery.domain.model.Delivery;
import mk.ukim.finki.emt.delivery.domain.model.DeliveryId;
import mk.ukim.finki.emt.delivery.domain.model.DeliveryItemId;
import mk.ukim.finki.emt.delivery.domain.model.DeliveryState;
import mk.ukim.finki.emt.delivery.domain.repository.DeliveryRepository;
import mk.ukim.finki.emt.delivery.domain.valueobjects.Product;
import mk.ukim.finki.emt.delivery.services.forms.DeliveryForm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DeliveryService implements IDeliveryService{
    private final DeliveryRepository deliveryRepository;
    private final Validator validator;

    @Override
    public Delivery findById(@NonNull DeliveryId id) {
        return deliveryRepository.findById(id).orElseThrow(() -> new DeliveryNotFoundException(id.getId()));
    }

    @Override
    public DeliveryId placeDelivery(@NonNull DeliveryForm delivery) {
        var violations = validator.validate(delivery);

        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Invalid order data");
        }

        var o = new Delivery(Instant.now(), delivery.getState(), delivery.getType(), delivery.getClient());

        return o.getId();
    }

    @Override
    public void cancelDelivery(@NonNull DeliveryId id) {
        var order = findById(id);

        order.changeState(DeliveryState.FAILED);

        deliveryRepository.saveAndFlush(order);
    }

    @Override
    public void addItem(@NonNull DeliveryId id, @NonNull Product product, @NonNull Integer quantity) {
        var order = findById(id);

        order.addItem(product, quantity);

        deliveryRepository.saveAndFlush(order);
    }

    @Override
    public void removeItem(@NonNull DeliveryId id, @NonNull DeliveryItemId item) {
        var order = findById(id);

        order.removeItem(item);

        deliveryRepository.saveAndFlush(order);
    }

    @Override
    public List<Delivery> listAll() {
        return deliveryRepository.findAll();
    }
}
