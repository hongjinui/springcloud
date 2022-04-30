package com.example.catalogservice.service;

import com.example.catalogservice.dto.CatalogDTO;
import com.example.catalogservice.jpa.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
    CatalogEntity findCatalogByProductId(String productId);
    CatalogDTO createCatalog(CatalogDTO catalogDTO);
}
