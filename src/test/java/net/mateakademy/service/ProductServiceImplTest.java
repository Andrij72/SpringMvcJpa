package net.mateakademy.service;

import net.mateakademy.dto.Producer;
import net.mateakademy.dto.Product;
import net.mateakademy.entities.ProductEntity;
import net.mateakademy.mappers.ProducerMapper;
import net.mateakademy.mappers.ProductMapper;
import net.mateakademy.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application_test.properties")
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProducerService producerService;
    @Autowired
    private ProductRepository repository;

    private ProducerMapper producerMapper = Mappers.getMapper(ProducerMapper.class);
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    private Product product;

    @Before
    public void setUp() {
        Producer producer = new Producer()
                .setName("HUAWEY");

        producerService.createProducer(producer);

        product = new Product()
                .setName("SmartPhone")
                .setPrice(new BigDecimal("150.00"))
                .setProducer(producerMapper.mapProducerToProducerEntity(producerService.getProducerById(1L)));

        productService.createProduct(product);
    }

    @Test
    public void createProduct() {
        Product testProduct = new Product()
                .setName("Notebook")
                .setPrice(new BigDecimal("1000.00"))
                .setProducer(producerMapper.mapProducerToProducerEntity(producerService.getProducerById(1L)));

        productService.createProduct(testProduct);

        ProductEntity productEntity = repository.findById(7L).orElse(null);
        assertEquals(testProduct, productEntity);
    }

    @Test
    public void getProductById() {
        ProductEntity productEntity = productMapper.mapProductToProductEntity(productService.getProductById(1L));
        assertEquals(product, productEntity);
    }

    @Test
    public void deleteProductId() {
        productService.deleteProductId(1L);
        assertNull(productService.getProductById(1L));
    }

    @Test
    public void getAllProducts() {
        assertEquals(2, productService.getAllProducts().size());
    }
}
