package mk.ukim.finki.emt.restaurant.port;


import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.restaurant.domain.model.Restaurant;
import mk.ukim.finki.emt.restaurant.domain.model.RestaurantId;
import mk.ukim.finki.emt.restaurant.services.IRestaurantService;
import mk.ukim.finki.emt.restaurant.services.forms.RestaurantForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@AllArgsConstructor
public class RestaurantResource {
    private final IRestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> findAll() {
        return restaurantService.findAll();
    }

    @PostMapping("/add")
    public Restaurant addRestaurant(@RequestBody RestaurantForm restaurantForm) {
        return restaurantService.createRestaurant(restaurantForm);
    }

    @PutMapping("/update/{id}")
    public Restaurant updateRestaurant(@PathVariable RestaurantId id, @RequestBody RestaurantForm restaurantForm) {
        return restaurantService.updateRestaurant(id, restaurantForm);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRestaurant(@PathVariable RestaurantId id) {
        restaurantService.deleteRestaurant(id);
    }
}
