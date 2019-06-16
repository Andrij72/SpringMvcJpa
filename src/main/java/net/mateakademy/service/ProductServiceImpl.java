package net.mateakademy.service;

import java.util.List;
import lombok.AllArgsConstructor;
import net.mateakademy.dto.Product;
import net.mateakademy.mappers.ProductMapper;
import net.mateakademy.repository.ProductRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Override
    public void createProduct(Product product) {
        repository.save(mapper.mapProductToProductEntity(product));
    }

    @Override
    public Product getProductById(Long id) {
        return mapper.mapProductEntityToProduct(repository.findById(id).orElse(null));
    }

    @Override
    public void deleteProductId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return mapper.mapProductEntityListToProductList(repository.findAll());
    }
}
