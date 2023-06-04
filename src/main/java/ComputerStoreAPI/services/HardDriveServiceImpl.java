package ComputerStoreAPI.services;

import ComputerStoreAPI.dto.DesktopDto;
import ComputerStoreAPI.dto.HardDriveDto;
import ComputerStoreAPI.mapper.ProductMapper;
import ComputerStoreAPI.model.Desktop;
import ComputerStoreAPI.model.HardDrive;
import ComputerStoreAPI.repositories.HardDriveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HardDriveServiceImpl implements HardDriveService {
    private final ProductMapper productMapper;
    private final HardDriveRepository hardDriveRepository;

    @Override
    public HardDriveDto addHardDrive(HardDriveDto hardDriveDto) {
        HardDrive hardDrive = (HardDrive) productMapper.convertToEntity(hardDriveDto);
        HardDrive savedHardDrive = hardDriveRepository.save(hardDrive);
        return (HardDriveDto) productMapper.convertToDto(savedHardDrive);
    }

    @Override
    public HardDriveDto updateHardDrive(Long id, HardDriveDto hardDriveDto) {
        Optional<HardDrive> optionalDesktop = hardDriveRepository.findById(id);
        if (optionalDesktop.isPresent()) {
            HardDrive hardDrive = optionalDesktop.get();
            hardDrive.setSerialNumber(hardDriveDto.getSerialNumber());
            hardDrive.setManufacturer(hardDriveDto.getManufacturer());
            hardDrive.setPrice(hardDriveDto.getPrice());
            hardDrive.setQuantity(hardDriveDto.getQuantity());
            hardDrive.setCapacity(hardDriveDto.getCapacity());

            HardDrive updatedHardDrive = hardDriveRepository.save(hardDrive);
            return (HardDriveDto) productMapper.convertToDto(updatedHardDrive);
        } else {
            throw new RuntimeException("HardDrive not found with id: " + id);
        }
    }
}
