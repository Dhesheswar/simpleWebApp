package com.spring.simpleWebApp.controller;

import com.spring.simpleWebApp.model.Product;
import com.spring.simpleWebApp.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
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
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
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
    public ResponseEntity<?> updateProductById(@PathVariable int prodId,
                                                @RequestBody Product product){
        return new ResponseEntity<>(service.updateProductByID(prodId,product),HttpStatus.OK);
    }
    @DeleteMapping("/products/{prodId}")
    public ResponseEntity<?> deleteProductBId(@PathVariable int prodId){
        return new ResponseEntity<>(service.deleteProductByID(prodId),HttpStatus.OK);
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
    @GetMapping("/products/fetch/{prodId}/image")
    public ResponseEntity<?> fetchProduct(@PathVariable int prodId){
         try{
            Product product1 = service.getProductById(prodId);
            byte[] imageFile = product1.getImageData();
            return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product1.getImageType()))
                .body(imageFile);
         }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NO_CONTENT);
         }                                             
    }
}
