package com.szaman.webflux.repositories;

import com.szaman.webflux.model.Product;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The type Product repositories.
 */
@Repository
public class ProductRepositories {

    /**
     * The Product data.
     */
    static final Map<String, Product> productData;

    static
    {
        productData = new HashMap<>();
        productData.put("1",new Product("1","Product 01", "N001", "Product Details 01","Product url 01"));
        productData.put("2",new Product("2","Product 02", "N002", "Product Details 02","Product url 02"));
        productData.put("3",new Product("3","Product 03", "N003", "Product Details 03","Product url 03"));
        productData.put("4",new Product("4","Product 04", "N004", "Product Details 04","Product url 04"));
        productData.put("5",new Product("5","Product 05", "N005", "Product Details 05","Product url 05"));
        productData.put("6",new Product("6","Product 06", "N006", "Product Details 06","Product url 06"));
        productData.put("7",new Product("7","Product 07", "N007", "Product Details 07","Product url 07"));
        productData.put("8",new Product("8","Product 08", "N008", "Product Details 08","Product url 08"));
        productData.put("9",new Product("9","Product 09", "N009", "Product Details 09","Product url 09"));
        productData.put("10",new Product("10","Product 10", "N0010", "Product Details 10","Product url 10"));
    }

    /**
     * Find product by id mono.
     *
     * @param productId the product id
     * @return the mono
     */
    public Mono<Product> findProductById(String productId)
    {
        return Mono.just(productData.get(productId));
    }

    /**
     * Find all products flux.
     *
     * @return the flux
     */
    public Flux<Product> findAllProducts()
    {
        return Flux.fromIterable(productData.values());
    }

    /**
     * Update product mono.
     *
     * @param productId   the product id
     * @param productName the product name
     * @return the mono
     */
    public Mono<Product> updateProduct(String productId, String productName)
    {
        Product existingProduct= productData.get(productId);
        if(existingProduct!=null)
        {
            existingProduct.setProductName(productName);
        }
        return Mono.just(Objects.requireNonNull(existingProduct));
    }
}
