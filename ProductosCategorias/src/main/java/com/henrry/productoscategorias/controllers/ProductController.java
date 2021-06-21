package com.henrry.productoscategorias.controllers;

import com.henrry.productoscategorias.models.Category;
import com.henrry.productoscategorias.models.CategoryProduct;
import com.henrry.productoscategorias.models.Product;
import com.henrry.productoscategorias.services.CategoryProductServ;
import com.henrry.productoscategorias.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryProductServ categoryProductServ;

    public ProductController(ProductService productService, CategoryProductServ categoryProductServ) {
        this.productService = productService;
        this.categoryProductServ = categoryProductServ;
    }

    @GetMapping("/new")
    public String newSong(@ModelAttribute("product") Product product) {
        return "product/newProduct.jsp";
    }

    @PostMapping("/new")
    public String addSong(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if(result.hasErrors()) {
            return "product/newProduct.jsp";
        } else {
            productService.createProduct(product);
            return "redirect:/";
        }
    }

    @GetMapping("/{id}")
    public String addCategoryProduct(@PathVariable("id") Long id,
                                       @ModelAttribute("categoryProduct") CategoryProduct categoryProduct,
                                       Model model) {
        Product product = productService.findProduct(id);
        List<Category> categories = productService.categoriesAvailables(product); // encuentra las categorias que no tiene el prroducto
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "product/newProductCategory.jsp";
    }

    @PostMapping("/{id}")
    public String addCategoryToProduct(@PathVariable("id") Long id,
                                       @ModelAttribute("categoryProduct") CategoryProduct categoryProduct,
                                       BindingResult result) {
        if(result.hasErrors()) {
            return "product/newProductCategory.jsp";
        } else {
            Product product = productService.findProduct(id);
            categoryProduct.setProduct(product);
            categoryProductServ.joinCategoryProduct(categoryProduct);
            return "redirect:/";
        }
    }

}
