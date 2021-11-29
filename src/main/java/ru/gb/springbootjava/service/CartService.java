package ru.gb.springbootjava.service;

import org.springframework.stereotype.Component;
import ru.gb.springbootjava.entity.Product;

import java.util.HashMap;
import java.util.function.Consumer;

@Component
public class CartService implements Consumer<Product> {
    private final HashMap<Product, Integer> cart = new HashMap<>();

    public void add(Product product) {
        if (cart.containsKey(product))
            cart.put(product, cart.get(product) + 1);
        else
            cart.put(product, 1);
    }

    public void deleteByProductId(Integer id) {
        cart.remove(id);
    }

    public HashMap<Product, Integer> showProductList() {
        return cart;
    }


    @Override
    public void accept(Product product) {
        add(product);
    }
}