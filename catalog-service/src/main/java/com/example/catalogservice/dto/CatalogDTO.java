package com.example.catalogservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatalogDTO implements Serializable {
    private String productId;
    private String productName;
    private Integer stock;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
