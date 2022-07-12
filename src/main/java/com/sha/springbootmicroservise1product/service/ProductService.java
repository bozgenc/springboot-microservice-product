package com.sha.springbootmicroservise1product.service;
import com.sha.springbootmicroservise1product.model.Product;
import com.sha.springbootmicroservise1product.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ProductService implements IProductService{

    private final IProductRepository repository;

    public ProductService(IProductRepository repository){
        this.repository = repository;
    }

    @Override
    public Product saveProduct(Product product) {
        product.setCreateTime(LocalDateTime.now());
        return  repository.save(product);
    }

    @Override
    public void deleteProductById(Long id){
        repository.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts(){
        return repository.findAll();
    }
}
