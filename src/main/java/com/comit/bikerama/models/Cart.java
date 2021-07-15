package com.comit.bikerama.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal totalPayable;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CartArticle> cartArticleList = new ArrayList<>();

    
    //private Date dateAdded;//fecha compra
    //private Date dateShipping; //fecha de envio
    //@Enumerated(EnumType.STRING)    
    //private StatusShippingCart statusShippingCart = StatusShippingCart.ACTIVO;
    
   
    //articulo vendible y producto es lo que esta en stock
    public BigDecimal getTotalPayable(){
        return cartArticleList.stream().map(a -> a.getTotalPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
