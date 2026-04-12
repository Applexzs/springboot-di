package com.applexzs.springboot.di.app.springbootdi.repositories;

import com.applexzs.springboot.di.app.springbootdi.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryJson implements IProductRepository{

    private List<Product> list;



    public ProductRepositoryJson(Resource resource) {
        readValueJson(resource);
    }
    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("product.json");
        readValueJson(resource);
    }

    private void readValueJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getFile(),Product[].class));
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }



    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p -> {
            return p.getId().equals(id);
        }).findFirst().orElseThrow();
    }
}
