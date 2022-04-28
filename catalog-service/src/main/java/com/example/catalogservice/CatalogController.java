package com.example.catalogservice;


import com.example.catalogservice.jpa.CatalogEntity;
import com.example.catalogservice.service.CatalogServiceImpl;
import com.example.catalogservice.vo.RequestCatalog;
import com.example.catalogservice.vo.ResponseCatalog;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog-service")
public class CatalogController {

    private Environment env;
    private CatalogServiceImpl catalogService;

    @Autowired
    public CatalogController(Environment env, CatalogServiceImpl catalogService) {
        this.env = env;
        this.catalogService = catalogService;
    }

//    @PostMapping(value = "/catalogs")
//    public ResponseEntity<ResponseCatalog> createCatalog(@RequestBody RequestCatalog catalog){
//
//
//
//    }

    @GetMapping(value = "/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalogs(){

        Iterable<CatalogEntity> catalogList = catalogService.findCatalogByAll();

        List<ResponseCatalog> result = new ArrayList<>();
        catalogList.forEach(v ->{
            result.add( new ModelMapper().map(v, ResponseCatalog.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);



    }


}
