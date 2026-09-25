package com.spring.simpleWebApp.service;

import com.spring.simpleWebApp.model.Product;
import com.spring.simpleWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
        return repo.findById(prodId).orElse(null);
    }

    public void addProduct(Product prod){
        repo.save(prod);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    public Product updateProductByID(int prodId,Product product){
        for(Product p : repo.findAll()){
            if(p.getProdId() == prodId){
                return repo.save(p);
            }
        }
        return null;
    }

    public Product deleteProductByID(int prodId){
        Product product = getProductById(prodId);
        if(product!=null){
            repo.deleteById(prodId);
            return product;
        }else{
            return null; 
        } 
    }

    public Product searchProduct(String keyword){
        return repo.searchByQuery(keyword);
    }
}
