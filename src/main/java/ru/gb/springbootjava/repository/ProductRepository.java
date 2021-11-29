package ru.gb.springbootjava.repository;

import org.springframework.stereotype.Component;
import ru.gb.springbootjava.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    public Optional<Product> findByID(int id){
        if(id < productList.size()) {
            return Optional.ofNullable(productList.get(id));
        }else{
            return Optional.empty();
        }
    }

    public List<Product> findAll(){
        return productList;
    }

    public void add(Product product){
        product.setId(productList.size());
        productList.add(product);
    }

    public void edit(Product product){
        productList.set(product.getId(), product);
    }

    public void deleteByID(int id){
        if(id < productList.size()) {
            productList.remove(id);
        }
    }

    public int size(){
        return productList.size();
    }
}
