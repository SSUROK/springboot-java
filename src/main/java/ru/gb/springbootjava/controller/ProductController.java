package ru.gb.springbootjava.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbootjava.entity.Product;
import ru.gb.springbootjava.service.ProductService;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ResponseBody
    public String helloSpringBoot(){
        return "Hello Spring Boot";
    }

    @RequestMapping(value="/create", method = RequestMethod.GET)
    public String create(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "create-product";
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public String processCreate(Product product){
         if(product.getId() == null){
            productService.add(product);
         } else{
             productService.edit(product);
         }
         return "redirect:/product/all";
    }

    @RequestMapping(value="/id={id}", method = RequestMethod.GET)
     public String getProductByID(Model model, @PathVariable Integer id){
        Product product = productService.returnByID(id);
        model.addAttribute("product", product);
        return "product";
     }

     @RequestMapping(path = "/delete", method = RequestMethod.GET)
     public String delete(@RequestParam Integer id){
        productService.deleteByID(id);
         return "redirect:/product/all";
     }

     @RequestMapping(path = "/edit", method = RequestMethod.GET)
     public String edit(Model model, @RequestParam Integer id){
        Product product = productService.returnByID(id);
        model.addAttribute("product", product);
        return "create-product";
     }
    
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String showProducts(Model model){
        List<Product> productList = productService.returnAll();
        model.addAttribute("productsList", productList);
        return "product-list";
    }

}
