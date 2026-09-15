package com.spring.simpleWebApp.service;

import com.spring.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    List<Product> prodList = new ArrayList<>(Arrays.asList(new Product(101,"iphone",80000),
            new Product(102,"oneplus",5000)));

    public List<Product> getAllProducts(){
        return prodList;
    }

    public Product getProductById(int prodId){
        for(Product p : prodList){
            if(p.getProdId() == prodId){
                return p;
            }
        }
        Product p = new Product(000,"No Item",0);
        return p;
    }

    public void addProduct(Product prod){
        prodList.add(prod);
    }

    public void updateProductByID(int prodId){
        for(Product p : prodList){
            if(p.getProdId() == prodId){
                p.setProdPrice(1111);
            }
        }
    }

    public void deleteProductByID(int prodId){
        int index=0;
        for(int i=0;i<prodList.size();i++){
            if(prodList.get(i).getProdId() == prodId){
                index=i;break;
            }
        }
        prodList.remove(index);
    }
}
