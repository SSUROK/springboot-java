package ru.gb.springbootjava.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.springbootjava.entity.Product;
import ru.gb.springbootjava.service.ShopServiceImpl;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@RequiredArgsConstructor
@Component
@Scope("prototype")
public class Buyer {

    private final ShopServiceImpl shopController;

    @PostConstruct
    public void init() {
        shopController.enterToShop();
    }

    public void purchase(Integer id) {
        shopController.addProductFromCartById(id);
    }

    public HashMap<Product, Integer> showCart() {
        return shopController.showProductsInCart();
    }


}
