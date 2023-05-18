package mk.ukim.finki.emt.restaurant.domain.repository;

import mk.ukim.finki.emt.restaurant.domain.model.Restaurant;
import mk.ukim.finki.emt.restaurant.domain.model.RestaurantId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  RestaurantRepository extends JpaRepository<Restaurant, RestaurantId> {
}
