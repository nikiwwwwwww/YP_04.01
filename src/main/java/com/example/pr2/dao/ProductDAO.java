package com.example.pr2.dao;


import com.example.pr2.Repository.ProductRepository;
import com.example.pr2.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDAO {
    private final ProductRepository productRepository;

    @Autowired
    public ProductDAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> index() {
        return productRepository.findAll();
    }
    public Product show(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public void save(Product product) {
        productRepository.save(product);
    }
    public void update(int id, Product updatedProduct) {
        Product productToBeUpdated = show(id);
        if (productToBeUpdated != null) {
            productToBeUpdated.setName(updatedProduct.getName());
            productToBeUpdated.setDescription(updatedProduct.getDescription());
            productToBeUpdated.setPrice(updatedProduct.getPrice());
            productRepository.save(updatedProduct);
        }
    }
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}