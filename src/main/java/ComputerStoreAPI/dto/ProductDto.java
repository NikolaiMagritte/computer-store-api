package ComputerStoreAPI.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String serialNumber;
    private String manufacturer;
    private double price;
    private int quantity;
}
