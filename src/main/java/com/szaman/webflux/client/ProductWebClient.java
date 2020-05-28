package com.szaman.webflux.client;

import com.szaman.webflux.model.Product;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The type Product web client.
 */
public class ProductWebClient {

    /**
     * The Client.
     */
    WebClient client = WebClient.create("http://localhost:8080");

    /**
     * Consume.
     */
    public void consume() {

        Mono<Product> productMono = client.get()
            .uri("/products/{productId}", "1")
            .retrieve()
            .bodyToMono(Product.class);

        productMono.subscribe(System.out::println);
        
        Flux<Product> productFlux = client.get()
            .uri("/products")
            .retrieve()
            .bodyToFlux(Product.class);
        
        productFlux.subscribe(System.out::println);

        Product product = new Product("1","Product updated 01", "N001", "Product Details 01","Product url 01");
        Mono<Product> updateProductMono = client.post()
                .uri("/products/update")
                .body(Mono.just(product), Product.class)
                .retrieve()
                .bodyToMono(Product.class);

        updateProductMono.subscribe(System.out::println);
    }
}