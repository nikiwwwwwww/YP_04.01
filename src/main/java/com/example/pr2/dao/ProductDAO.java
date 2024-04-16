package com.example.pr2.dao;


import com.example.pr2.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAO {
    private static int PRODUCTS_COUNT;
    private final List<Product> products;

    {
        products = new ArrayList<>();

        products.add(new Product(++PRODUCTS_COUNT, "Product1", "Description1", 19.99));
        products.add(new Product(++PRODUCTS_COUNT, "Product2", "Description2", 29.99));
        products.add(new Product(++PRODUCTS_COUNT, "Product3", "Description3", 39.99));
    }

    public List<Product> index() {
        return products;
    }

    public Product show(int id) {
        return products.stream().filter(product -> product.getId() == id).findAny().orElse(null);
    }

    public void save(Product product) {
        product.setId(++PRODUCTS_COUNT);
        products.add(product);
    }

    public void update(int id, Product updatedProduct) {
        Product productToBeUpdated = show(id);

        if (productToBeUpdated != null) {
            productToBeUpdated.setName(updatedProduct.getName());
            productToBeUpdated.setDescription(updatedProduct.getDescription());
            productToBeUpdated.setPrice(updatedProduct.getPrice());
        }
    }

    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}