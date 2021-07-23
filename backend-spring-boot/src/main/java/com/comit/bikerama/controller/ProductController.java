package com.comit.bikerama.controller;

import java.util.List;

import com.comit.bikerama.domain.Product;
import com.comit.bikerama.service.impl.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll(){
        List<Product> producList = productService.findAll();
        return ResponseEntity.ok(producList);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findById(@PathVariable(name = "id") Long id){
        Product product = productService.findById(id).get();
        return ResponseEntity.ok(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> update(@PathVariable(name = "id") Long id, @RequestBody Product product){

        Product productSelect = productService.findById(id).get();
        productSelect.setName(product.getName());
        productSelect.setDescription(product.getDescription());
        productSelect.setPrice(product.getPrice());
        productSelect.setSupplier(product.getSupplier());
        Product productUpdate = productService.update(productSelect);
        return ResponseEntity.ok(productUpdate);
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
