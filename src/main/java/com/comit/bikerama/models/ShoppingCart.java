package com.comit.bikerama.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal totalPayable;


    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Article> articles = new ArrayList<>();

    
    //private Date dateAdded;//fecha compra
    //private Date dateShipping; //fecha de envio
    //@Enumerated(EnumType.STRING)    
    //private StatusShippingCart statusShippingCart = StatusShippingCart.ACTIVO;
    
   
    //articulo vendible y producto es lo que esta en stock
    public BigDecimal getTotalPayable(){
        return articles.stream().map(Article::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
