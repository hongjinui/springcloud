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
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {

    public GlobalFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        return ((exchange, chain) -> {

            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            // 요청 아이디
            log.info("Global Filter PRE. request id -> {} ", request.getId());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                // 응답 코드
                log.info("Global Filter post. response status code -> {}", response.getStatusCode());
            }));

        });

    }

    @Data
    static class Config{

        private String baseMessage;     // 메시지
        private boolean preLogger;      // 전처리
        private boolean postLogger;     // 후처리

    }

}
