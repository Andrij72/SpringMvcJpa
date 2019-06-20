package net.mateakademy.mappers;

import net.mateakademy.dto.Product;
import net.mateakademy.entities.ProductEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductMapper {

    ProductEntity mapProductToProductEntity(Product product);

    @Mapping(target = "id", source = "id")
    Product mapProductEntityToProduct(ProductEntity productEntity);

    List<Product> mapProductEntityListToProductList(List<ProductEntity> productEntities);
}
