package xyz.defe.gateway.controller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeDecorator;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FallbackController {
    @Autowired
    private Gson gson;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("defaultFallback")
    public Mono<String> defaultFallback(ServerWebExchange exchange) {
        Exception exception = exchange.getAttribute(ServerWebExchangeUtils.CIRCUITBREAKER_EXECUTION_EXCEPTION_ATTR);
        ServerWebExchange delegate = ((ServerWebExchangeDecorator) exchange).getDelegate();
        log.error("request failed: {}", delegate.getRequest().getURI().getPath(), exception);

        Map map = new HashMap<>();
        map.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());
        map.put("message", "request failed:" + delegate.getRequest().getURI().getPath());
        map.put("error", exception.getMessage());
        return Mono.just(gson.toJson(map));
    }

    @GetMapping("productServiceFallback")
    public Mono<String> productServiceFallback(ServerWebExchange exchange) {
        Exception exception = exchange.getAttribute(ServerWebExchangeUtils.CIRCUITBREAKER_EXECUTION_EXCEPTION_ATTR);
        ServerWebExchange delegate = ((ServerWebExchangeDecorator) exchange).getDelegate();
        log.error("request to PRODUCT SERVICE failed: {}", delegate.getRequest().getURI().getPath(), exception);

        Map map = new HashMap<>();
        map.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());
        map.put("message", "request to PRODUCT SERVICE failed:" + delegate.getRequest().getURI().getPath());
        map.put("error", exception.getMessage());
        return Mono.just(gson.toJson(map));
    }
}
