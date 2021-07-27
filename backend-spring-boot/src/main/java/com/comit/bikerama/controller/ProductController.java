package com.comit.bikerama.controller;

import java.util.List;
import java.util.Optional;

import com.comit.bikerama.domain.Product;
import com.comit.bikerama.service.impl.ProductServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/products")
    public ResponseEntity<?> findAll() {
        List<Product> producList = productService.findAll();
        return ResponseEntity.ok().body(producList);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        Optional<Product> product = productService.findById(id);
        return product.map(response -> ResponseEntity.ok().body(response)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/products")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product productInsert = productService.save(product);
        return ResponseEntity.ok(productInsert);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> update(@PathVariable(name = "id") Long id, @RequestBody Product product) {

        Product productSelect = productService.findById(id).get();
        productSelect.setName(product.getName());
        productSelect.setDescription(product.getDescription());
        productSelect.setPrice(product.getPrice());
        productSelect.setStock(product.getStock());
        productSelect.setSupplier(product.getSupplier());
        Product productUpdate = productService.update(productSelect);
        return ResponseEntity.ok(productUpdate);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(productService.delete(id));
    }
    /*
     * @RequestMapping(value = "/new", method = RequestMethod.GET) public String
     * newProduct(Model model){ model.addAttribute("product", new Product()); return
     * "newProduct"; }
     * 
     * @PostMapping(value = "/create") public String
     * createProduct(@RequestParam(value = "name") String name, @RequestParam(value
     * = "description") String description, @RequestParam(value = "codeProduct")
     * String code, Model model){ Product product = new Product();
     * product.setNombre(nombre); product.setDescription(description);
     * product.setCodeProduct(code); product = productService.save(product);
     * model.addAttribute("product", product); return "seeProduct"; }
     */

}
