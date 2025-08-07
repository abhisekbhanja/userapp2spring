package com.example.userprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userprofile.model.Category;
import com.example.userprofile.model.Product;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category findByCategoryName(String categoryName);

}
