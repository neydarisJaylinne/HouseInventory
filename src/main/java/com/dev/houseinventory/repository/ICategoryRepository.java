package com.dev.houseinventory.repository;

import com.dev.houseinventory.entities.Category;
import com.dev.houseinventory.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
