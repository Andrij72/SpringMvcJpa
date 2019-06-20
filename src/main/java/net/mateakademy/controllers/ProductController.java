package net.mateakademy.controllers;

import lombok.AllArgsConstructor;
import net.mateakademy.dto.Producer;
import net.mateakademy.dto.Product;
import net.mateakademy.mappers.ProducerMapper;
import net.mateakademy.service.ProducerServiceImpl;
import net.mateakademy.service.ProductServiceImpl;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private final ProductServiceImpl productService;
    private final ProducerServiceImpl producerService;
    private final ProducerMapper producerMapper = Mappers.getMapper(ProducerMapper.class);

    @GetMapping("admin/products")
    public ModelAndView getAllProducts() {
        ModelAndView modelAndView = new ModelAndView("product_list_Admin");
        modelAndView.addObject("products", productService.getAllProducts());

        return modelAndView;
    }

    @GetMapping("admin/product-form")
    public ModelAndView productForm() {
        Product product = new Product();
        ModelAndView modelAndView = new ModelAndView("product_form_Admin");

        modelAndView.addObject("product", product);
        modelAndView.addObject("producers", producerService.getAllProducers());

        return modelAndView;
    }

    @PostMapping("admin/save-product")
    public RedirectView saveProduct(@ModelAttribute("product") Product product) {
        Producer producerByName = producerService.getProducerByName(product.getProducerName());
        product.setProducer(producerMapper.mapProducerToProducerEntity(producerByName));
        productService.createProduct(product);

        return new RedirectView("admin/products");
    }

    @GetMapping("admin/edit-product/{id}")
    public ModelAndView editProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit_product_Admin");
        Product product = productService.getProductById(id);
        modelAndView.addObject("product", product);
        modelAndView.addObject("producers", producerService.getAllProducers());

        return modelAndView;
    }

    @GetMapping("admin/delete-product/{id}")
    public RedirectView deleteProduct(@PathVariable(name = "id") Long id) {
        productService.deleteProductId(id);

        return new RedirectView("admin/products");
    }

    @GetMapping("user/products")
    public ModelAndView getAllProductsForUser() {
        ModelAndView modelAndView = new ModelAndView("product_list_User");
        modelAndView.addObject("products", productService.getAllProducts());
        return modelAndView;
    }
}
