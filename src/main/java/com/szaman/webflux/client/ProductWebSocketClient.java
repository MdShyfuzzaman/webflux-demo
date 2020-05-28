package com.szaman.webflux.client;

import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;

import java.net.URI;

/**
 * The type Product web socket client.
 */
public class ProductWebSocketClient {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        WebSocketClient client = new ReactorNettyWebSocketClient();
        
        client.execute(URI.create("ws://localhost:8080/product-feed"), session -> session.receive()
            .map(WebSocketMessage::getPayloadAsText)
            .doOnNext(System.out::println)
            .then())
            .block(); // to subscribe and return the value
    }
}
