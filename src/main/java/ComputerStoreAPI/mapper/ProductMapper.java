package ComputerStoreAPI.mapper;

import ComputerStoreAPI.dto.*;
import ComputerStoreAPI.model.*;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDto convertToDto(Product product) {
        if (product instanceof Laptop) {
            return createLaptopDto((Laptop) product);
        } else if (product instanceof Desktop) {
            return createDesktopDto((Desktop) product);
        } else if (product instanceof Monitor) {
            return createMonitorDto((Monitor) product);
        } else if (product instanceof HardDrive) {
            return createHardDriveDto((HardDrive) product);
        } else {
            return createProductDto(product);
        }
    }

    public Product convertToEntity(ProductDto dto) {
        if (dto instanceof LaptopDto) {
            return createLaptop((LaptopDto) dto);
        } else if (dto instanceof DesktopDto) {
            return createDesktop((DesktopDto) dto);
        } else if (dto instanceof MonitorDto) {
            return createMonitor((MonitorDto) dto);
        } else if (dto instanceof HardDriveDto) {
            return createHardDrive((HardDriveDto) dto);
        } else {
            return createProduct(dto);
        }
    }

    private LaptopDto createLaptopDto(Laptop laptop) {
        LaptopDto laptopDto = new LaptopDto();
        copyCommonFields(laptop, laptopDto);
        laptopDto.setScreenSize(laptop.getScreenSize());
        return laptopDto;
    }

    private DesktopDto createDesktopDto(Desktop desktop) {
        DesktopDto desktopDto = new DesktopDto();
        copyCommonFields(desktop, desktopDto);
        desktopDto.setFormFactor(desktop.getFormFactor());
        return desktopDto;
    }

    private MonitorDto createMonitorDto(Monitor monitor) {
        MonitorDto monitorDto = new MonitorDto();
        copyCommonFields(monitor, monitorDto);
        monitorDto.setDiagonal(monitor.getDiagonal());
        return monitorDto;
    }

    private HardDriveDto createHardDriveDto(HardDrive hardDrive) {
        HardDriveDto hardDriveDto = new HardDriveDto();
        copyCommonFields(hardDrive, hardDriveDto);
        hardDriveDto.setCapacity(hardDrive.getCapacity());
        return hardDriveDto;
    }

    private ProductDto createProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        copyCommonFields(product, productDto);
        return productDto;
    }

    private void copyCommonFields(Product source, ProductDto destination) {
        destination.setSerialNumber(source.getSerialNumber());
        destination.setManufacturer(source.getManufacturer());
        destination.setPrice(source.getPrice());
        destination.setQuantity(source.getQuantity());
    }

    private Laptop createLaptop(LaptopDto laptopDto) {
        Laptop laptop = new Laptop();
        copyCommonFields(laptopDto, laptop);
        laptop.setScreenSize(laptopDto.getScreenSize());
        return laptop;
    }

    private Desktop createDesktop(DesktopDto desktopDto) {
        Desktop desktop = new Desktop();
        copyCommonFields(desktopDto, desktop);
        desktop.setFormFactor(desktopDto.getFormFactor());
        return desktop;
    }

    private Monitor createMonitor(MonitorDto monitorDto) {
        Monitor monitor = new Monitor();
        copyCommonFields(monitorDto, monitor);
        monitor.setDiagonal(monitorDto.getDiagonal());
        return monitor;
    }

    private HardDrive createHardDrive(HardDriveDto hardDriveDto) {
        HardDrive hardDrive = new HardDrive();
        copyCommonFields(hardDriveDto, hardDrive);
        hardDrive.setCapacity(hardDriveDto.getCapacity());
        return hardDrive;
    }

    private Product createProduct(ProductDto productDto) {
        Product product = new Product();
        copyCommonFields(productDto, product);
        return product;
    }

    private void copyCommonFields(ProductDto source, Product destination) {
        destination.setSerialNumber(source.getSerialNumber());
        destination.setManufacturer(source.getManufacturer());
        destination.setPrice(source.getPrice());
        destination.setQuantity(source.getQuantity());
    }
}
