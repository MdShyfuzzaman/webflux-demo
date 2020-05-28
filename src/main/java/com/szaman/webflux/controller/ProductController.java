package com.szaman.webflux.controller;

import com.szaman.webflux.model.Product;
import com.szaman.webflux.repositories.ProductRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The type Product controller.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    /**
     * The Product repositories.
     */
    private ProductRepositories productRepositories;

    /**
     * Instantiates a new Product controller.
     *
     * @param productRepositories the product repositories
     */
    public ProductController(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }

    /**
     * Gets product by id.
     *
     * @param productId the product id
     * @return the product by id
     */
    @GetMapping("/{productId}")
    private Mono<Product> getProductById(@PathVariable String productId) {
        return productRepositories.findProductById(productId);
    }

    /**
     * Gets all product.
     *
     * @return the all product
     */
    @GetMapping
    private Flux<Product> getAllProduct() {
        return productRepositories.findAllProducts();
    }

    /**
     * Update product mono.
     *
     * @param product the product
     * @return the mono
     */
    @PostMapping("/update")
    private Mono<Product> updateProduct(@RequestBody Product product) {
        return productRepositories.updateProduct(product.getProductId(), product.getProductName());
    }

}
