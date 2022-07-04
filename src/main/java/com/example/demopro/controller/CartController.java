package com.example.demopro.controller;

import com.example.demopro.model.Cart;
import com.example.demopro.model.Product;
import com.example.demopro.service.CartService;
import com.example.demopro.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CartController {
    private final ProductService productService;
    @Autowired
    private CartService cartService;



    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable(name = "id") Long id){
        Product product = productService.get(id);
        Cart cart = new Cart();
        cart.setName(product.getName());
        cart.setBrand(product.getBrand());
        cart.setMadein(product.getMadein());
        cart.setPrice(product.getPrice());
        cartService.save(cart);

        return "redirect:/customerpage";
    }

    @GetMapping("/cart")
    public String cart(Model model){
        List<Cart> allCart = cartService.cartList();
        model.addAttribute("allCart", allCart);
        return "mycart";
    }

    @RequestMapping("/cartdelete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        cartService.delete(id);

        return "redirect:/cart";
    }

}
