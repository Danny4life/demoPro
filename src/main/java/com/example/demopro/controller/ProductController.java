package com.example.demopro.controller;

import com.example.demopro.model.Product;
import com.example.demopro.service.CartService;
import com.example.demopro.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;
    @Autowired
    private CartService cartService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product")
    public String viewHomePage(Model model) {
        List<Product> listProducts = productService.productList();
        model.addAttribute("listProducts", listProducts);

        return "admin_welcome";
    }

    @RequestMapping("/new")
    public String showNewProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/product";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("edit_product");

        Product product = productService.get(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        productService.delete(id);

        return "redirect:/product";
    }



    @RequestMapping("/customerpage")
    public String HomePage(Model model) {
        List<Product> listProducts = productService.productList();
        model.addAttribute("listProducts", listProducts);

        return "personal_page";
    }

}
