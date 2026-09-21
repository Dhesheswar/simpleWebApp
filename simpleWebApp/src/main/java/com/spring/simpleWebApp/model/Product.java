package com.spring.simpleWebApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    private int prodId;
    private String prodName;
    private int prodPrice;

    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;
}
