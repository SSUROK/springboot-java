package ru.gb.springbootjava.controller;

import ru.gb.springbootjava.service.CartService;

public interface ShopController {
    CartService getCart();
}
