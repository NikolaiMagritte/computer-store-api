package ComputerStoreAPI.services;

import ComputerStoreAPI.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> getAllProducts();
    Optional<ProductDto> getProductById(Long id);
    List<ProductDto> getProductsByType(String type);
    boolean deleteProduct(Long id);
}
