package com.dev.houseinventory.controller;

import com.dev.houseinventory.dtos.ProductResponseDto;
import com.dev.houseinventory.entities.Product;
import com.dev.houseinventory.services.IProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (path = "/products", produces = "application/json; charset=utf-8")
@RequiredArgsConstructor
public class ProductsController {
    
    @Autowired
    IProductsService iProductsService;

    @PostMapping
    public ProductResponseDto addProduct(@RequestBody Product product) {
        return iProductsService.addProduct(product);
    }

    @PutMapping( path ="/update/{id}")
    public ProductResponseDto updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        return  iProductsService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        iProductsService.deleteProduct(id);
        return "Product correctly deleted";
    }

    @GetMapping
    public List<Product> getAllProducts() {
       return iProductsService.getAllProducts();
    }

    @GetMapping("/name/{productName}")
    public Optional<Product> getProductByName(@PathVariable String productName) {
        return iProductsService.getProductByName(productName);
    }

    @GetMapping("/category/{category}")
    public  Optional<List<Product>> getProductsByCategory(@PathVariable String category) {
        return iProductsService.getProductsByCategory(category);
    }

    //requerir un request
    public  Optional<List<Product>>getProductsByExpDate(Date initialDate, Date finalDate) {
        return iProductsService.getProductsByExpDate(initialDate, finalDate);
    }

    @GetMapping("/quantity/{quantity}")
    public  Optional<List<Product>> getProductsByQuantity(@PathVariable int quantity) {
        return  iProductsService.getProductsByQuantity(quantity);
    }
}
