package ComputerStoreAPI.dto;

import ComputerStoreAPI.model.ScreenSize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaptopDto extends ProductDto {
    private ScreenSize screenSize;
}
