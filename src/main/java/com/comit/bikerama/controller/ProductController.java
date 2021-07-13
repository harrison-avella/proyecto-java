package com.comit.bikerama.controller;

import com.comit.bikerama.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "newProduct";
    }

    @PostMapping(value = "/create")
    public String createProduct(@RequestParam(value = "name") String name, @RequestParam(value = "description") String description, @RequestParam(value = "codeProduct") String code, Model model){
        Product product = new Product();
        product.setNombre(nombre);
        product.setDescription(description);
        product.setCodeProduct(code);
        product = productService.save(product);
        model.addAttribute("product", product);
        return "seeProduct";
    }
}
