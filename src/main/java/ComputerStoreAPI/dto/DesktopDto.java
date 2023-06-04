package ComputerStoreAPI.dto;

import ComputerStoreAPI.model.FormFactor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DesktopDto extends ProductDto {
    private FormFactor formFactor;
}
