package com.dev.houseinventory.services;

import com.dev.houseinventory.dtos.ProductResponseDto;
import com.dev.houseinventory.entities.Product;
import com.dev.houseinventory.repository.IProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductsService{

    @Autowired
    IProductRepository productRepository;
    private final ProductResponseDto productResponseDto;

    public ProductService(ProductResponseDto productResponseDto) {
        this.productResponseDto = productResponseDto;
    }

    @Override
    @Transactional
    public ProductResponseDto addProduct(Product product) {
        if (product.getProductId() != null) {
            // Producto existente, asegura la sincronización antes de guardar
            Product existingProduct = productRepository.findById(product.getProductId())
                    .orElse(productRepository.save(product));
            productRepository.save(existingProduct);
        } else {
            // Producto nuevo
            productRepository.save(product);
        }
        mapProducts(product);
        return productResponseDto;
    }

    private void mapProducts (Product product){
        productResponseDto.setProductId(product.getProductId());
        productResponseDto.setProductCategory(product.getProductCategory());
        productResponseDto.setProductName(product.getProductName());
        productResponseDto.setProductQuantity(product.getProductQuantity());
        productResponseDto.setProductExpirationDate(product.getProductExpirationDate());
    }

    @Override
    public ProductResponseDto  updateProduct(Product product) {
        //productRepository.update(product);
        productRepository.findById(product.getProductId())
                .ifPresent(foundedProduct -> {
                    foundedProduct.setProductCategory(product.getProductCategory());
                    foundedProduct.setProductName(product.getProductName());
                    foundedProduct.setProductQuantity(product.getProductQuantity());
                    foundedProduct.setProductExpirationDate(product.getProductExpirationDate());
                    productRepository.save(foundedProduct);
                });

        mapProducts(product);
        return productResponseDto;
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductByName(String productName) {
        return productRepository.findByName(productName);
    }

    @Override
    public  Optional<List<Product>> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public  Optional<List<Product>>getProductsByExpDate(Date initialDate, Date finalDate) {
        return productRepository.findByExpDate(initialDate, finalDate);
    }

    @Override
    public  Optional<List<Product>> getProductsByQuantity(int quantity) {
        return productRepository.findByQuantity(quantity);
    }
}
