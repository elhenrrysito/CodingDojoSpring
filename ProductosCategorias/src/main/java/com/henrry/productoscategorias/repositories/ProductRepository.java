package com.henrry.productoscategorias.repositories;

import com.henrry.productoscategorias.models.Category;
import com.henrry.productoscategorias.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
    List<Product> findByNameContaining(String search);
    List<Product> findByCategoriesNotContaining(Category category);
}
