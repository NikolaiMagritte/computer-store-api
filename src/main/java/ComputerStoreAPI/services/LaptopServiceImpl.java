package ComputerStoreAPI.services;

import ComputerStoreAPI.dto.LaptopDto;
import ComputerStoreAPI.mapper.ProductMapper;
import ComputerStoreAPI.model.Laptop;
import ComputerStoreAPI.repositories.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LaptopServiceImpl implements LaptopService {
    private final LaptopRepository laptopRepository;
    private final ProductMapper productMapper;

    @Override
    public LaptopDto addLaptop(LaptopDto laptopDto) {
        Laptop laptop = (Laptop) productMapper.convertToEntity(laptopDto);
        Laptop savedLaptop = laptopRepository.save(laptop);
        return (LaptopDto) productMapper.convertToDto(savedLaptop);
    }

    @Override
    public LaptopDto updateLaptop(Long id, LaptopDto laptopDto) {
        Optional<Laptop> optionalLaptop = laptopRepository.findById(id);
        if (optionalLaptop.isPresent()) {
            Laptop laptop = optionalLaptop.get();
            laptop.setSerialNumber(laptopDto.getSerialNumber());
            laptop.setManufacturer(laptopDto.getManufacturer());
            laptop.setPrice(laptopDto.getPrice());
            laptop.setQuantity(laptopDto.getQuantity());
            laptop.setScreenSize(laptopDto.getScreenSize());

            Laptop updatedLaptop = laptopRepository.save(laptop);
            return (LaptopDto) productMapper.convertToDto(updatedLaptop);
        } else {
            throw new RuntimeException("Laptop not found with id: " + id);
        }
    }
}
