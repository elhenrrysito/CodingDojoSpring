package com.henrry.productoscategorias.services;

import com.henrry.productoscategorias.models.Category;
import com.henrry.productoscategorias.models.Product;
import com.henrry.productoscategorias.repositories.CategoryRepository;
import com.henrry.productoscategorias.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategory(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            return categoryOptional.get();
        } else {
            return null;
        }
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<Product> productsAvailables(Category category) {
        return productRepository.findByCategoriesNotContaining(category);
    }


}
