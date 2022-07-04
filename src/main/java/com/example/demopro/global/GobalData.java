package com.example.demopro.global;

import com.example.demopro.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GobalData {
    public static List<Product> cart;
    static {
        cart = new ArrayList<Product>();
    }
}
