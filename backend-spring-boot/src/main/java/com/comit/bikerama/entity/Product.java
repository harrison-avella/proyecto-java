package com.comit.bikerama.entity;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // se usa para que
                                                        // autoincremente
    private Long id;
    private String name;
    private BigDecimal price = BigDecimal.ZERO;

    // private String description;
    // private Integer stock = 0;
    // private String supplier = "";
    // private String image = "";

    // private BigDecimal cantMin = BigDecimal.TEN;
    // private BigDecimal cantCurrent = BigDecimal.ZERO;
    // private BigDecimal iva = new BigDecimal("1.21");

    public Product() {}

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /*
     * private BigDecimal getPrice() { return price; } public BigDecimal
     * getPriceWithIva() { return price.multiply(iva); } public BigDecimal
     * getPriceOutOfIva() { return getPrice(); } // el compareTo da cero si son
     * iguales-1 si es menos y 1 si es mayor public boolean isThereStored() {
     * return cantCurrent.compareTo(cantMin) <= 0; }
     */



}
