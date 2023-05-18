package mk.ukim.finki.emt.delivery.port;


import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.delivery.domain.model.Delivery;
import mk.ukim.finki.emt.delivery.domain.model.DeliveryId;
import mk.ukim.finki.emt.delivery.domain.model.DeliveryItemId;
import mk.ukim.finki.emt.delivery.domain.valueobjects.Product;
import mk.ukim.finki.emt.delivery.services.IDeliveryService;
import mk.ukim.finki.emt.delivery.services.forms.DeliveryForm;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/delivery")
@AllArgsConstructor
public class DeliveryResource {
    private final IDeliveryService deliveryService;

    @GetMapping
    public List<Delivery> listAll() {
        return deliveryService.listAll();
    }

    @GetMapping("/{id}")
    public Delivery findById(@PathVariable DeliveryId id) {
        return deliveryService.findById(id);
    }

    @PostMapping("/place")
    public void placeDelivery(@RequestBody DeliveryForm delivery, HttpServletResponse response) throws IOException {
        deliveryService.placeDelivery(delivery);
        response.sendRedirect("/api/delivery");
    }

    @PostMapping("/{id}/cancel")
    public void cancelDelivery(@PathVariable DeliveryId id, HttpServletResponse response) throws IOException {
        deliveryService.cancelDelivery(id);
        response.sendRedirect("/api/delivery");
    }

    @PostMapping("/{id}/add")
    public void addItem(@PathVariable DeliveryId id, @RequestBody Product product, @RequestBody Integer quantity, HttpServletResponse response) throws IOException {
        deliveryService.addItem(id, product, quantity);
        response.sendRedirect("/api/delivery");
    }

    @PostMapping("/{id}/remove")
    public void removeItem(@PathVariable DeliveryId id, @RequestBody DeliveryItemId item, HttpServletResponse response) throws IOException {
        deliveryService.removeItem(id, item);
        response.sendRedirect("/api/delivery");
    }
}
