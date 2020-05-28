package com.szaman.webflux;

import com.szaman.webflux.client.ProductWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Demo application.
 */
@SpringBootApplication
public class DemoApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        ProductWebClient employeeWebClient = new ProductWebClient();
        employeeWebClient.consume();
    }

}
