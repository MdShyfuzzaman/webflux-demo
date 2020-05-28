package com.szaman.webflux.event;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Product creation event.
 */
@Data
@AllArgsConstructor
public class ProductCreationEvent {
    /**
     * The Product id.
     */
    private String productId;
    /**
     * The Creation time.
     */
    private String creationTime;
}
