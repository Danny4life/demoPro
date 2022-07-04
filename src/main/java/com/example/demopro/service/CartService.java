package com.example.demopro.service;

import com.example.demopro.model.Cart;
import com.example.demopro.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> cartList (){
        return cartRepository.findAll();
    }

    public void save(Cart cart){
        cartRepository.save(cart);
    }

    public Cart get(Long id){
        return cartRepository.findById(id).get();
    }

    public void delete(Long id){
        cartRepository.deleteById(id);
    }
}
