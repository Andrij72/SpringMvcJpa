package net.mateakademy.service;

import java.util.List;
import net.mateakademy.dto.Product;

public interface ProductService {
    void createProduct(Product product);

    Product getProductById(Long id);

    void deleteProductId(Long id);

    List<Product> getAllProducts();
}
