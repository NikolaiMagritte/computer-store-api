package ComputerStoreAPI.services;

import ComputerStoreAPI.dto.LaptopDto;

public interface LaptopService {
    LaptopDto addLaptop(LaptopDto laptopDto);
    LaptopDto updateLaptop(Long id, LaptopDto laptopDto);
}
