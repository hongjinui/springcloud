package com.example.apigatewayservice.filter;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
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
//            StopWatch stopWatch = new StopWatch();

            log.info("---------------Logger Filter PRE---------------");
            log.info("Request call method name -> {}",request.getMethod());
            log.info("Request call path -> {}", request.getPath());
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
