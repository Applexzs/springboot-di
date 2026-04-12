package com.applexzs.springboot.di.app.springbootdi;


import com.applexzs.springboot.di.app.springbootdi.repositories.IProductRepository;
import com.applexzs.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {
    @Value("classpath:product.json")
    private Resource resource;

    @Bean
    IProductRepository productRepositoryJson(){
        return new ProductRepositoryJson(resource);
    }

}
