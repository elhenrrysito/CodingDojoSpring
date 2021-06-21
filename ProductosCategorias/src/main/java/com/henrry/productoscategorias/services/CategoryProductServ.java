package com.henrry.productoscategorias.services;

import com.henrry.productoscategorias.models.CategoryProduct;
import com.henrry.productoscategorias.repositories.CategoryProductRepo;
import com.henrry.productoscategorias.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryProductServ {
    private final CategoryProductRepo categoryProductRepo;

    public CategoryProductServ(CategoryProductRepo categoryProductRepo) {
        this.categoryProductRepo = categoryProductRepo;
    }

    public CategoryProduct joinCategoryProduct(CategoryProduct categoryProduct) {
        return categoryProductRepo.save(categoryProduct);
    }
}
