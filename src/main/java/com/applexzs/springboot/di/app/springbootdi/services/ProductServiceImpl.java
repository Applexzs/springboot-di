package com.applexzs.springboot.di.app.springbootdi.services;

import com.applexzs.springboot.di.app.springbootdi.models.Product;
import com.applexzs.springboot.di.app.springbootdi.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    @Qualifier("productRepositoryJson")
    private IProductRepository repository;

    @Autowired
    private Environment environment;


//    public ProductServiceImpl(@Qualifier("productFoo") IProductRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * environment.getProperty("config.tax", Double.class);
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
//            p.setPrice(priceTax.longValue());
//            return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
