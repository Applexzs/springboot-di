package com.applexzs.springboot.di.app.springbootdi.services;

import com.applexzs.springboot.di.app.springbootdi.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Long id);
}
