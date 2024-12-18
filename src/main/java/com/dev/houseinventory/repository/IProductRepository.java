package com.dev.houseinventory.repository;

import com.dev.houseinventory.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

   /*
   @Modifying
   @Query(value = "UPDATE products p SET p.productName = :name, p.productQuantity = :quantity, p.productExpirationDate = :dates, p.productCategory = :category WHERE p.productId = :id")
   void update(@Param("id") long id,
               @Param("name") String name, @Param("quantity") int quantity, @Param("dates") Date dates, @Param("category") long category);*/

   @Query(value = "SELECT p FROM products p WHERE p.productName = :name")
   Optional<Product> findByName(String name);

   @Query(value = "SELECT p FROM products p WHERE p.productCategory = :category")
   Optional<List<Product>> findByCategory(String category);

   @Query(value = "SELECT p FROM products p WHERE p.productExpirationDate BETWEEN :initialDate AND :finalDate")
   Optional<List<Product>> findByExpDate(Date initialDate, Date finalDate);

   @Query(value = " SELECT p FROM products p WHERE p.productQuantity = :quantity")
   Optional<List<Product>> findByQuantity(int quantity);


}
