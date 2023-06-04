package ComputerStoreAPI.model;

import ComputerStoreAPI.dto.ProductDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serialNumber;
    private String manufacturer;
    private double price;
    private int quantity;
}
