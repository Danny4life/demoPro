package com.example.demopro.service;

import com.example.demopro.model.Product;
import com.example.demopro.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> productList (){
        return productRepository.findAll();
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public Product get(Long id){
        return productRepository.findById(id).get();
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
