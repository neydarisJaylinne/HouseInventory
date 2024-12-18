package com.dev.houseinventory.services;

import com.dev.houseinventory.dtos.ProductResponseDto;
import com.dev.houseinventory.entities.Category;
import com.dev.houseinventory.entities.Product;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface IProductsService {

    public ProductResponseDto addProduct(Product product);

    public ProductResponseDto updateProduct(Product product);

    //public void updateProduct(long productId, String productName, int productQuantity, Date expirationDate, long productCategory);

    public void deleteProduct(long productId);

    public List<Product> getAllProducts();

    public Optional<Product> getProductByName(String productName);

    public Optional<List<Product>> getProductsByCategory(String category);

    public  Optional<List<Product>> getProductsByExpDate(Date initialDate, Date finalDate);

    public  Optional<List<Product>> getProductsByQuantity (int quantity);
}
