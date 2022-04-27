package com.example.apigatewayservice.filter;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggerFilter extends AbstractGatewayFilterFactory<LoggerFilter.Config> {

    public LoggerFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        return ((exchange, chain) -> {

            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("---------------Logger Filter PRE---------------");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("---------------Logger Filter POST---------------");

            }));
        });

    }

    @Data
    static class Config{
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}