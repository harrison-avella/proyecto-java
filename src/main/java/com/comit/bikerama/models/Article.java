package com.comit.bikerama.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal cant = BigDecimal.ZERO;
    private  BigDecimal priceUnit = BigDecimal.ONE;
    
    @OneToOne
    private Product product;

    @ManyToOne
    @JoinColumn(name = "shoping_cart_id")
    private Cart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public BigDecimal getTotalPrice(){
        return priceUnit.multiply(cant);
    }
}
