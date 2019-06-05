package net.mateakademy.mapping;

import net.mateakademy.dto.Product;
import net.mateakademy.model.ProductEntity;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
public class ProductMapper {
    public Product mapProductEntityToProduct(ProductEntity entity){
        return new Product()
                .setId(entity.getId())
                .setName(entity.getName())
                .setPrice(entity.getPrice())
                .setManufacturer(entity.getManufacturer());
    }

    public java.util.List<Product> mapProductEntitiesToProducts(java.util.List<ProductEntity> entities){
        return entities.stream()
                .map(this::mapProductEntityToProduct)
                .collect(toList());
    }

    public ProductEntity mapProductToProductEntity(Product product){
        ProductEntity entity = new ProductEntity()
                .setName(product.getName())
                .setPrice(product.getPrice())
                .setManufacturer(product.getManufacturer());
        entity.setId(product.getId());
        return entity;
    }
}
