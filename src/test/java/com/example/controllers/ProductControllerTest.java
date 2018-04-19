package com.example.controllers;

import com.example.entities.Product;
import com.example.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductRepository productRepository;


    @Test
    public void testCreateTicket() {

        Product product = new Product();
        product.setId(1);
        product.setName("Martin");
        product.setExpirationDate(new java.util.Date());
        product.setCategory(1);
        product.setCost(2000);

        Mockito.when(productRepository.save(product)).thenReturn(product);

        assertThat(productController.CreateProduct(product).getBody().equals(product));
    }

    @Configuration
    static class Config {

        @Bean
        public ProductController productController() {
            // Assuming MessagingProperties has default ctor.
            return new ProductController();
        }

        // Same for MessagingPropertiesRefactor
    }

}