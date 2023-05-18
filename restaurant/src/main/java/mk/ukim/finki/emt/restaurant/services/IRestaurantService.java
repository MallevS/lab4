package mk.ukim.finki.emt.restaurant.services;

import mk.ukim.finki.emt.restaurant.domain.model.Restaurant;
import mk.ukim.finki.emt.restaurant.domain.model.RestaurantId;
import mk.ukim.finki.emt.restaurant.services.forms.RestaurantForm;

import java.util.List;

public interface IRestaurantService {
    Restaurant findById(RestaurantId id);

    Restaurant createRestaurant(RestaurantForm restaurant);

    Restaurant updateRestaurant(RestaurantId id, RestaurantForm restaurant);

    void deleteRestaurant(RestaurantId id);

    List<Restaurant> findAll();
}
