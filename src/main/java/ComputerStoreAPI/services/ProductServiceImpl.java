package ComputerStoreAPI.services;

import ComputerStoreAPI.dto.ProductDto;
import ComputerStoreAPI.mapper.ProductMapper;
import ComputerStoreAPI.model.*;
import ComputerStoreAPI.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final DesktopRepository desktopRepository;
    private final LaptopRepository laptopRepository;
    private final MonitorRepository monitorRepository;
    private final HardDriveRepository hardDriveRepository;
    private final ProductMapper productMapper;


    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDto> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(productMapper::convertToDto);
    }

    @Override
    public List<ProductDto> getProductsByType(String type) {
        List<Product> products;
        switch (type) {
            case "Desktop":
                List<Desktop> desktops = desktopRepository.findAll();
                products = new ArrayList<>(desktops);
                break;
            case "Laptop":
                List<Laptop> laptops = laptopRepository.findAll();
                products = new ArrayList<>(laptops);
                break;
            case "Monitor":
                List<Monitor> monitors = monitorRepository.findAll();
                products = new ArrayList<>(monitors);
                break;
            case "HardDrive":
                List<HardDrive> hardDrives = hardDriveRepository.findAll();
                products = new ArrayList<>(hardDrives);
                break;
            default:
                products = productRepository.findAll();
                break;
        }

        List<ProductDto> productsDto = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = productMapper.convertToDto(product);
            productsDto.add(productDto);
        }
        return productsDto;
    }

    @Override
    public boolean deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return true;
        }
        return false;
    }
}
