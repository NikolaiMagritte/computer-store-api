package ComputerStoreAPI.services;

import ComputerStoreAPI.dto.MonitorDto;

public interface MonitorService {
    MonitorDto addMonitor(MonitorDto monitorDto);
    MonitorDto updateMonitor(Long id, MonitorDto monitorDto);
}
