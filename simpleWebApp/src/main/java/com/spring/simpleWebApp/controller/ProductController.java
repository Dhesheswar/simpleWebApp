package com.spring.simpleWebApp.controller;

import com.spring.simpleWebApp.model.Product;
import com.spring.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/products") // by default RequestMapping is GET request
    public List<Product> getProducts(){
        return service.getAllProducts();
    }
    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId){
        return service.getProductById(prodId);
    }
    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        service.addProduct(prod);
    }
    @PutMapping("/products/{prodId}")
    public void updateProductById(@PathVariable int prodId){
        service.updateProductByID(prodId);
    }
    @DeleteMapping("/products/{prodId}")
    public void deleteProductBId(@PathVariable int prodId){
        service.deleteProductByID(prodId);
    }
}
