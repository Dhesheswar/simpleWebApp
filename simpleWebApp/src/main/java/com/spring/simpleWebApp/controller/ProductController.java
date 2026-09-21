package com.spring.simpleWebApp.controller;

import com.spring.simpleWebApp.model.Product;
import com.spring.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/products") // by default RequestMapping is GET request
    public List<Product> getProducts(){
        return service.getAllProducts();
    }
    @GetMapping("/products/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodId){
        Product prod = service.getProductById(prodId);
        if (prod != null) {
            return new ResponseEntity<>(service.getProductById(prodId), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
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
    @PostMapping("/products/image")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
                           @RequestPart MultipartFile imageFile){
        try{
            Product product1 = service.addProduct(product,imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NO_CONTENT);
        }
    }
}
