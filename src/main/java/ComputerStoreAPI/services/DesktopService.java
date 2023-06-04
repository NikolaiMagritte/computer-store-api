package ComputerStoreAPI.services;

import ComputerStoreAPI.dto.DesktopDto;

public interface DesktopService {
    DesktopDto addDesktopComputer(DesktopDto desktopDto);
    DesktopDto updateDesktopComputer(Long id, DesktopDto desktopDto);
}
