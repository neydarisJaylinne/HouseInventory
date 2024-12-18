package com.dev.houseinventory.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "category")
public class Category {
    @Id
    private Long categoryId;
    private String categoryName;


}
