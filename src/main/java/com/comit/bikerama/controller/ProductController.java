package com.comit.bikerama.controller;

import com.comit.bikerama.models.Product;
import com.comit.bikerama.services.impl.ProductService;
import com.comit.bikerama.services.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;


import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    //private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAll(){
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable(name = "id") Long id){
        return productService.findById(id);
    }

    @PutMapping("/products/{id}")
    public Product update(@PathVariable(name = "id") Long id, @RequestBody Product product){

        Product productSelect = productService.findById(id);
        productSelect.setName(product.getName());
        productSelect.setDescription(product.getDescription());
        productSelect.setPrice(product.getPrice());
        productSelect.setSupplier(product.getSupplier());

        return productService.update(productSelect);
    }

    /*
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
*/

}
