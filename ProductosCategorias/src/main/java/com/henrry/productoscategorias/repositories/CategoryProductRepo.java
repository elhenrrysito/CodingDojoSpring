package com.henrry.productoscategorias.repositories;

import com.henrry.productoscategorias.models.CategoryProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryProductRepo extends CrudRepository<CategoryProduct, Long> {


}
