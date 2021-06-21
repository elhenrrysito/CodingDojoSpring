package com.henrry.productoscategorias.controllers;

import com.henrry.productoscategorias.models.Category;
import com.henrry.productoscategorias.models.CategoryProduct;
import com.henrry.productoscategorias.models.Product;
import com.henrry.productoscategorias.services.CategoryProductServ;
import com.henrry.productoscategorias.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryProductServ categoryProductServ;

    public CategoryController(CategoryService categoryService, CategoryProductServ categoryProductServ) {
        this.categoryService = categoryService;
        this.categoryProductServ = categoryProductServ;
    }

    @GetMapping("/new")
    public String newCategory(@ModelAttribute("category") Category category) {
        return "category/newCategory.jsp";
    }

    @PostMapping("/new")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if(result.hasErrors()) {
            return "category/newCategory.jsp";
        } else {
            categoryService.createCategory(category);
            return "redirect:/";
        }
    }

    @GetMapping("/{id}")
    public String addProductCategory(@PathVariable("id") Long id,
                                     @ModelAttribute("categoryProduct")CategoryProduct categoryProduct,
                                     Model model) {
        Category category = categoryService.findCategory(id);
        List<Product> products = categoryService.productsAvailables(category);
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        return "category/newCategoryProduct.jsp";
    }

    @PostMapping("/{id}")
    public String addProductToCategory(@PathVariable("id") Long id,
                                       @ModelAttribute("categoryProduct") CategoryProduct categoryProduct,
                                       BindingResult result) {
        if(result.hasErrors()) {
            return "category/newCategoryProduct.jsp";
        } else {
            Category category = categoryService.findCategory(id);
            categoryProduct.setCategory(category);
            categoryProductServ.joinCategoryProduct(categoryProduct);
            return "redirect:/";
        }
    }
}
