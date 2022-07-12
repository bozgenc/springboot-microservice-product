package com.sha.springbootmicroservise1product.controller;

import com.sha.springbootmicroservise1product.model.Product;
import com.sha.springbootmicroservise1product.service.IProductService;
import com.sha.springbootmicroservise1product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private IProductService productService;

    public ProductController(IProductService service) {
        this.productService = service;
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

}
