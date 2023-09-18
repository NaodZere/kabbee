package OnlineBankingSystem.TesfaSolutions.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

@Embeddable
@Data
public class Address {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
