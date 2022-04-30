package com.example.catalogservice.service;

import com.example.catalogservice.dto.CatalogDTO;
import com.example.catalogservice.jpa.CatalogEntity;
import com.example.catalogservice.jpa.CatalogRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl implements CatalogService{

    private CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public Iterable<CatalogEntity> getAllCatalogs() {

        Iterable<CatalogEntity> catalogList = catalogRepository.findAll();

        return catalogList;

    }

    @Override
    public CatalogEntity findCatalogByProductId(String productId) {

        CatalogEntity catalog = catalogRepository.findByProductId(productId);

        return catalog;


    }

    @Override
    public CatalogDTO createCatalog(CatalogDTO CatalogDTO) {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CatalogEntity catalogEntity = mapper.map(CatalogDTO, CatalogEntity.class);

        catalogRepository.save(catalogEntity);

        return null;

    }
}


