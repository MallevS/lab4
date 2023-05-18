package mk.ukim.finki.emt.delivery.domain.exceptions;

public class DeliveryNotFoundException extends RuntimeException{
    public DeliveryNotFoundException(String message) {
        super(message);
    }
}
