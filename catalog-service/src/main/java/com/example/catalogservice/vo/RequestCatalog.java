package com.example.catalogservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestCatalog {

    private String productId;
    private String productName;
    private Integer unitPrice;
    private Integer stock;

}
