package com.henrry.productoscategorias.repositories;

import com.henrry.productoscategorias.models.Category;
import com.henrry.productoscategorias.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
    List<Category> findByProductsNotContaining(Product product);
}
