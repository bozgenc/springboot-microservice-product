package com.sha.springbootmicroservise1product.service;

import com.sha.springbootmicroservise1product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductService {
    Product saveProduct(Product product);

    void deleteProductById(Long id);

    List<Product> getAllProducts();
}
