package ComputerStoreAPI.services;

import ComputerStoreAPI.dto.MonitorDto;
import ComputerStoreAPI.mapper.ProductMapper;
import ComputerStoreAPI.model.Monitor;
import ComputerStoreAPI.repositories.MonitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonitorServiceImpl implements MonitorService {
    private final MonitorRepository monitorRepository;
    private final ProductMapper productMapper;

    @Override
    public MonitorDto addMonitor(MonitorDto monitorDto) {
        Monitor monitor = (Monitor) productMapper.convertToEntity(monitorDto);
        Monitor savedMonitor = monitorRepository.save(monitor);
        return (MonitorDto) productMapper.convertToDto(savedMonitor);
    }

    @Override
    public MonitorDto updateMonitor(Long id, MonitorDto monitorDto) {
        Optional<Monitor> optionalMonitor = monitorRepository.findById(id);
        if (optionalMonitor.isPresent()) {
            Monitor monitor = optionalMonitor.get();
            monitor.setSerialNumber(monitorDto.getSerialNumber());
            monitor.setManufacturer(monitorDto.getManufacturer());
            monitor.setPrice(monitorDto.getPrice());
            monitor.setQuantity(monitorDto.getQuantity());
            monitor.setDiagonal(monitorDto.getDiagonal());

            Monitor updatedMonitor = monitorRepository.save(monitor);
            return (MonitorDto) productMapper.convertToDto(updatedMonitor);
        } else {
            throw new RuntimeException("Monitor not found with id: " + id);
        }
    }
}
