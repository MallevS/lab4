package mk.ukim.finki.emt.restaurant.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.restaurant.domain.model.Restaurant;
import mk.ukim.finki.emt.restaurant.domain.repository.RestaurantRepository;
import mk.ukim.finki.emt.restaurant.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.financial.Money;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final RestaurantRepository restaurantRepository;

    @PostConstruct
    public void init() {
        if (restaurantRepository.count() == 0) {
            restaurantRepository.saveAll(List.of(
                    new Restaurant("Product 1", new Quantity(1), new Money(Currency.MKD, 150)),
                    new Restaurant("Product 2", new Quantity(2), new Money(Currency.MKD, 230)),
                    new Restaurant("Product 3", new Quantity(3), new Money(Currency.MKD, 380)),
                    new Restaurant("Product 4", new Quantity(4), new Money(Currency.MKD, 490)),
                    new Restaurant("Product 5", new Quantity(5), new Money(Currency.MKD, 520))
            ));
        }
    }
}
