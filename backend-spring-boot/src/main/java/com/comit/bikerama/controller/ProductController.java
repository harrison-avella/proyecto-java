package com.comit.bikerama.controller;

import java.math.BigDecimal;
import java.util.List;
import com.comit.bikerama.dto.Message;
import com.comit.bikerama.dto.ProductDto;
import com.comit.bikerama.entity.Product;
import com.comit.bikerama.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/product")
@CrossOrigin(origins = "*")
public class ProductController {
    /*
     * private static final Logger logger =
     * LoggerFactory.getLogger(ProductController.class);
     */
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<?> findAll() {
        List<Product> producList = productService.findAll();
        return ResponseEntity.ok().body(producList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        if (!productService.existsById(id)) {
            return new ResponseEntity(
                    new Message("No se encontro producto con este id"),
                    HttpStatus.NOT_FOUND);
        }
        Product product = productService.findById(id).get();
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(
            @PathVariable(name = "name") String name) {
        if (!productService.existsByName(name)) {
            return new ResponseEntity(
                    new Message("No se encontro producto con este nombre"),
                    HttpStatus.NOT_FOUND);
        }
        Product product = productService.findByName(name).get();
        return ResponseEntity.ok().body(product);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductDto productDto) {
        if (StringUtils.isBlank(productDto.getName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"),
                    HttpStatus.BAD_REQUEST);
        //devuelve 1 si es mayor, 0 si es igual, -1 si es menor
        if (productDto.getPrice().compareTo(BigDecimal.ZERO) > 0)
            return new ResponseEntity(new Message("El precio es obligatorio"),
                    HttpStatus.BAD_REQUEST);
        if (productService.existsByName(productDto.getName()))
            return new ResponseEntity(
                    new Message("Ya existe un producto con este nombre"),
                    HttpStatus.BAD_REQUEST);
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productService.save(product);
        //return ResponseEntity.ok().body(product);
        return new ResponseEntity(new Message("Producto creado"),
                HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id,
            @RequestBody ProductDto productDto) {
        if (!productService.existsById(id)) {
            return new ResponseEntity(
                    new Message("No se encontro producto con este id"),
                    HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(productDto.getName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"),
                    HttpStatus.BAD_REQUEST);
        if (productService.existsByName(productDto.getName()) && productService
                .findByName(productDto.getName()).get().getId() != id)
            return new ResponseEntity(
                    new Message("Ya existe un producto con este nombre"),
                    HttpStatus.BAD_REQUEST);
        //devuelve 1 si es mayor, 0 si es igual, -1 si es menor
        if (productDto.getPrice().compareTo(BigDecimal.ZERO) > 0)
            return new ResponseEntity(new Message("El precio es obligatorio"),
                    HttpStatus.BAD_REQUEST);

        Product product = productService.findById(id).get();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productService.save(product);
        //return ResponseEntity.ok().body(product);
        return new ResponseEntity(new Message("Producto actualizado"),
                HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        if (!productService.existsById(id)) {
            return new ResponseEntity(
                    new Message("No se encontro producto con este id"),
                    HttpStatus.NOT_FOUND);
        }
        productService.delete(id);
        return new ResponseEntity(new Message("Producto eliminado"),
                HttpStatus.OK);
    }
}
