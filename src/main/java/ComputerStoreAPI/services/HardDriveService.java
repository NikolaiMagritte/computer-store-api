package ComputerStoreAPI.services;

import ComputerStoreAPI.dto.HardDriveDto;

public interface HardDriveService {
    HardDriveDto addHardDrive(HardDriveDto hardDriveDto);
    HardDriveDto updateHardDrive(Long id, HardDriveDto hardDriveDto);
}
