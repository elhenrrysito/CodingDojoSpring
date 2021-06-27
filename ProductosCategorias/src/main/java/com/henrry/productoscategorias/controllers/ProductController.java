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
    public String newProduct(@ModelAttribute("product") Product product) {
        return "product/newProduct.jsp";
    }

    @PostMapping("/new")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
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

    @PostMapping("/{idProduct}")
    public String addCategoryToProduct(@PathVariable("idProduct") Long idProduct,
                                       @ModelAttribute("categoryProduct") CategoryProduct categoryProduct,
                                       BindingResult result) {
        if(result.hasErrors()) {
            return "product/newProductCategory.jsp";
        } else {
            Product product = productService.findProduct(idProduct);
//            product.setCategories(categoryProduct.getCategory());
//            productService.updateProduct(product);
            categoryProduct.setProduct(product);
            // product.setCategories(category); <-- para agregar sin tabla intermedia
            categoryProductServ.joinCategoryProduct(categoryProduct);
            return "redirect:/products/" + idProduct;
        }
    }

}
