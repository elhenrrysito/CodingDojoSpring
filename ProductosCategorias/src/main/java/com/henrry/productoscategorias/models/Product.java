package com.henrry.productoscategorias.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="products")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=3, max=40)
    private String name;
    @Size(min=3, max=60)
    private String description;

    private double price;
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "categories_products",
            joinColumns = @JoinColumn(name="product_id"), // hace referencia a este ID en la tabla intermedia
            inverseJoinColumns = @JoinColumn(name="category_id") // hace referencia al ID de la otra tabla en la intermedia
    )
    private List<Category> categories;

    public void setCategories(Category category) {
        this.categories.add(category);
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}