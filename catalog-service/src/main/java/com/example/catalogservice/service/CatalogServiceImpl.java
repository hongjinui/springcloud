package com.example.catalogservice.service;

import com.example.catalogservice.jpa.CatalogEntity;
import com.example.catalogservice.jpa.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CatalogServiceImpl implements CatalogService{

    private CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public Iterable<CatalogEntity> findCatalogByAll() {

        Iterable<CatalogEntity> catalogList = catalogRepository.findAll();

        return catalogList;

    }
}
