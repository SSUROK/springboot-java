package ru.gb.hw7.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.hw7.dao.JpaProduct;
import ru.gb.hw7.entity.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final JpaProduct jpaProduct;

    public Product returnByID(Long id){
        return jpaProduct.findById(id);
    }

    public Iterable<Product> returnAll(){
        return jpaProduct.findAll();
    }

    public Iterable<Product> returnSorted(String sortOrder){
        return jpaProduct.sort(sortOrder);
    }

    public void add(Product product){
        jpaProduct.save(product);
    }

//    public void edit(Product product){
//        jpaProduct.edit(product);
//    }

    public void deleteByID(Long id){
        jpaProduct.deleteById(id);
    }
}