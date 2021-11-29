package ru.gb.springbootjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springbootjava.entity.Product;
import ru.gb.springbootjava.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product returnByID(int id){
        return productRepository.findByID(id).orElse(new Product());
    }

    public List<Product> returnAll(){
        return productRepository.findAll();
    }

    public void add(Product product){
        productRepository.add(product);
    }

    public void edit(Product product){
        productRepository.edit(product);
    }

    public void deleteByID(int id){
        if(id < productRepository.size()) {
            productRepository.deleteByID(id);
        }
    }
}
