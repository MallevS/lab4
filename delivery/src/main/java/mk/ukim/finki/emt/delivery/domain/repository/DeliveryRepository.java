package mk.ukim.finki.emt.delivery.domain.repository;

import mk.ukim.finki.emt.delivery.domain.model.Delivery;
import mk.ukim.finki.emt.delivery.domain.model.DeliveryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  DeliveryRepository extends JpaRepository<Delivery, DeliveryId> {
}
