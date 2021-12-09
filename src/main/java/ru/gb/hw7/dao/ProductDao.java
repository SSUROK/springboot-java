package ru.gb.hw7.dao;

import ru.gb.hw7.entity.Manufacturer;
import ru.gb.hw7.entity.Product;

import java.util.Collection;

public interface ProductDao {
    Iterable<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    void deleteAll(Collection<Product> products);
    void deleteById(Long id);
    void delete(Product product);
    Iterable<Product> sort(String sortOrder);
}
