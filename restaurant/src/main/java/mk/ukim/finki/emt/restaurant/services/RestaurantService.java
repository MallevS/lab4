package mk.ukim.finki.emt.restaurant.services;


import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.emt.restaurant.domain.exceptions.RestaurantNotFoundException;
import mk.ukim.finki.emt.restaurant.domain.model.Restaurant;
import mk.ukim.finki.emt.restaurant.domain.model.RestaurantId;
import mk.ukim.finki.emt.restaurant.domain.repository.RestaurantRepository;
import mk.ukim.finki.emt.restaurant.services.forms.RestaurantForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RestaurantService  implements IRestaurantService{
    private final RestaurantRepository restaurantRepository;
    private final Validator validator;

    @Override
    public Restaurant findById(@NonNull RestaurantId id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new RestaurantNotFoundException(id.getId()));
    }

    @Override
    public Restaurant createRestaurant(@NonNull RestaurantForm restaurant) {
        var violations = validator.validate(restaurant);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Invalid product data");
        }

        var newRestaurant = new Restaurant(restaurant.getName(), restaurant.getQuantity(), restaurant.getPrice());

        return restaurantRepository.saveAndFlush(newRestaurant);
    }

    @Override
    public Restaurant updateRestaurant(@NonNull RestaurantId id, @NonNull RestaurantForm restaurant) {
        var restaurantToUpdate = findById(id);

        restaurantToUpdate.updateRestaurant(restaurant.getName(), restaurant.getQuantity(), restaurant.getPrice());

        return restaurantRepository.saveAndFlush(restaurantToUpdate);
    }

    @Override
    public void deleteRestaurant(@NonNull RestaurantId id) {
        restaurantRepository.deleteById(id);
        restaurantRepository.flush();
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }
}
