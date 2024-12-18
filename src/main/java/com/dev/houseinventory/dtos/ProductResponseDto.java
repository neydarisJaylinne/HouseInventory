package com.dev.houseinventory.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@Component
public class ProductResponseDto {

    private Long productId;
    private String productName;
    private int productQuantity;
    private Date productExpirationDate;
    private int productCategory;

}
