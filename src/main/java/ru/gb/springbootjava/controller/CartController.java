package ru.gb.springbootjava.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.springbootjava.entity.Product;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final Buyer buyer;

    @RequestMapping(value="/add/id={id}", method = RequestMethod.GET)
    public String addToCartProductByID(Model model, @PathVariable Integer id){
        buyer.purchase(id);
        return "redirect:/cart/all";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String showCart(Model model){
        HashMap<Product, Integer> cart = buyer.showCart();
        model.addAttribute("cart", cart);
        return "cart";
    }
}
