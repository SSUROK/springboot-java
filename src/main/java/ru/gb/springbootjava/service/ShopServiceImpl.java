package ru.gb.springbootjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;
import ru.gb.springbootjava.controller.ShopController;
import ru.gb.springbootjava.entity.Product;
import ru.gb.springbootjava.repository.ProductRepository;
import ru.gb.springbootjava.service.CartService;

import java.util.HashMap;

@RequiredArgsConstructor
@Component
public class ShopServiceImpl implements ShopController {
    private final ProductRepository productRepository;
    private CartService cart;

    @Lookup
    @Override
    public CartService getCart() {
        return null;
    }

    public void showAssortment() {
        System.out.println(productRepository.findAll());
    }

    public void addProductFromCartById(Integer id) {
        productRepository.findByID(id).ifPresent(cart);
    }

    public void deleteProductFromCartById(Integer id) {
        cart.deleteByProductId(id);
    }

    public HashMap<Product, Integer> showProductsInCart() {
        return cart.showProductList();
    }

    public void enterToShop() {
        this.cart = getCart();
    }
}
