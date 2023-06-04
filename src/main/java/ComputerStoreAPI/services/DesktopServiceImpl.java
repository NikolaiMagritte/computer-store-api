package ComputerStoreAPI.services;

import ComputerStoreAPI.dto.DesktopDto;
import ComputerStoreAPI.mapper.ProductMapper;
import ComputerStoreAPI.model.Desktop;
import ComputerStoreAPI.repositories.DesktopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DesktopServiceImpl implements DesktopService {
    private final DesktopRepository desktopRepository;
    private final ProductMapper productMapper;

    @Override
    public DesktopDto addDesktopComputer(DesktopDto desktopDto) {
        Desktop desktop = (Desktop) productMapper.convertToEntity(desktopDto);
        Desktop savedDesktop = desktopRepository.save(desktop);
        return (DesktopDto) productMapper.convertToDto(savedDesktop);
    }

    @Override
    public DesktopDto updateDesktopComputer(Long id, DesktopDto desktopDto) {
        Optional<Desktop> optionalDesktop = desktopRepository.findById(id);
        if (optionalDesktop.isPresent()) {
            Desktop desktop = optionalDesktop.get();
            desktop.setSerialNumber(desktopDto.getSerialNumber());
            desktop.setManufacturer(desktopDto.getManufacturer());
            desktop.setPrice(desktopDto.getPrice());
            desktop.setQuantity(desktopDto.getQuantity());
            desktop.setFormFactor(desktopDto.getFormFactor());

            Desktop updatedDesktop = desktopRepository.save(desktop);
            return (DesktopDto) productMapper.convertToDto(updatedDesktop);
        } else {
            throw new RuntimeException("Desktop computer not found with id: " + id);
        }
    }
}
