package mk.ukim.finki.emt.delivery.domain.valueobjects;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.base.ValueObject;

@Getter
public class Product implements ValueObject {
    private final ProductId id;
    private final String name;
    private final String description;

    @JsonCreator
    public Product(String name, String description) {
        this.id = DomainObjectId.randomId(ProductId.class);
        this.name = name;
        this.description = description;
    }
}
