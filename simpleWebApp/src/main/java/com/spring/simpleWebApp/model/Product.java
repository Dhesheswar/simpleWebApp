package com.spring.simpleWebApp.model;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int prodId;
    private String prodName;
    private int prodPrice;

    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;
}
