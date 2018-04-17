package com.example.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.entities.Product;
import org.springframework.data.repository.query.Param;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query(value = "SELECT * FROM product p  where p.id = :id", nativeQuery = true)
    Product findById(@Param("id") int id);
}
