package com.example.catalogservice.jpa;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "catalog")
public class CatalogEntity extends BaseTimeEntity implements Serializable  {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 120, unique = true)
    private String productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Integer unitPrice;


//    @Column(nullable = false, updatable = false, insertable = false)
////    @ColumnDefault(value = "CURRENT_TIMESTAMP")
//    @CreatedDate
//    private LocalDateTime createdAt;

}
