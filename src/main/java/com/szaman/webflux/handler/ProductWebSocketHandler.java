package com.szaman.webflux.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.szaman.webflux.event.ProductCreationEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;

/**
 * The type Product web socket handler.
 */
@Component("EmployeeWebSocketHandler")
public class ProductWebSocketHandler implements WebSocketHandler {

    /**
     * The Om.
     */
    ObjectMapper om = new ObjectMapper();

    @Override
    public Mono<Void> handle(WebSocketSession webSocketSession) {

        Flux<String> employeeCreationEvent = Flux.generate(sink -> {
            ProductCreationEvent event = new ProductCreationEvent(randomUUID().toString(), now().toString());
            try {
                sink.next(om.writeValueAsString(event));
            } catch (JsonProcessingException e) {
                sink.error(e);
            }
        });

        return webSocketSession.send(employeeCreationEvent
            .map(webSocketSession::textMessage)
            .delayElements(Duration.ofSeconds(1)));
    }
}
