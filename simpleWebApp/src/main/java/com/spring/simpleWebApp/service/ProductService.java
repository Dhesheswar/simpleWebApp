package com.spring.simpleWebApp.service;

import com.spring.simpleWebApp.model.Product;
import com.spring.simpleWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;
//    List<Product> prodList = new ArrayList<>(Arrays.asList(new Product(101,"iphone",80000),
//            new Product(102,"oneplus",5000)));

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProductById(int prodId){
        return repo.findById(prodId).orElse(new Product());
    }

    public void addProduct(Product prod){
        repo.save(prod);
    }

    public void updateProductByID(int prodId){
        for(Product p : repo.findAll()){
            if(p.getProdId() == prodId){
                repo.save(p);
            }
        }
    }

    public void deleteProductByID(int prodId){
        repo.deleteById(prodId);
    }
}
