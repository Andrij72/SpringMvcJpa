package net.mateakademy.mappers;

import net.mateakademy.dto.Product;
import net.mateakademy.entities.ProducerEntity;
import net.mateakademy.entities.ProductEntity;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class ProductMapperImplTest {

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Test
    public void mapProductToProductEntity() {
        Product product = new Product()
                .setName("SmartPhone")
                .setPrice(new BigDecimal("150"))
                .setProducer(new ProducerEntity()
                        .setName("HUAWEY"));

        ProductEntity productEntity = mapper.mapProductToProductEntity(product);

        assertEquals(product, productEntity);
    }

    @Test
    public void mapProductEntityToProduct() {
        ProductEntity productEntity = new ProductEntity()
                .setName("SmartPhone")
                .setPrice(new BigDecimal("150"))
                .setProducer(new ProducerEntity()
                        .setName("HUAWEY"));

        Product product = mapper.mapProductEntityToProduct(productEntity);

        assertEquals(product, productEntity);

    }

    @Test
    public void mapProductEntityListToProductList() {
        List<ProductEntity> productEntities = new ArrayList<>();
        List<Product> products;

        ProductEntity productEntity = new ProductEntity()
                .setName("SmartPhone")
                .setPrice(new BigDecimal("150"))
                .setProducer(new ProducerEntity()
                        .setName("HUAWEY"));

        ProductEntity productEntitySecond = new ProductEntity()
                .setName("Notebook")
                .setPrice(new BigDecimal("1000"))
                .setProducer(new ProducerEntity()
                        .setName("HP"));

        productEntities.add(productEntity);
        productEntities.add(productEntitySecond);

        products = mapper.mapProductEntityListToProductList(productEntities);

        assertThat(products,is(productEntities));
    }

    @Test
    public void mapProductToProductEntityWithNullArgument() {
        ProductEntity productEntity = mapper.mapProductToProductEntity(null);
        assertNull(productEntity);
    }

    @Test
    public void mapProductEntityToProductWithNullArgument() {
        Product product = mapper.mapProductEntityToProduct(null);
        assertNull(product);
    }

    @Test
    public void mapProductEntityListToProductListWithNullArgument() {
        List<Product> products = mapper.mapProductEntityListToProductList(null);
        assertNull(products);
    }
}
