package com.example.orderservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestOrder {

    private String productId;
    private Integer qty;
    private Integer unitPrice;

    // 사용자에게 상품ID, 수량, 가격을 전달 받는다고 가정함

}
