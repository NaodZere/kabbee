package OnlineBankingSystem.TesfaSolutions.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Address {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
