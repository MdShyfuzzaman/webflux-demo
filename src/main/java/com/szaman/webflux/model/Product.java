package com.szaman.webflux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Product.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    /**
     * The Product id.
     */
    private String productId;
    /**
     * The Product name.
     */
    private String productName;
    /**
     * The Product code.
     */
    private String productCode;
    /**
     * The Product details.
     */
    private String productDetails;
    /**
     * The Product url.
     */
    private String productUrl;
}
