package com.comit.bikerama.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Entity(name="ShoppingCarts")
@Getter
@Setter
@NoArgsConstructor
public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private Date dateAdded;//fecha compra
    private Date dateShipping; //fecha de envio
    @Enumerated(EnumType.STRING)
    private StatusShippingCart statusShippingCart = StatusShippingCart.ACTIVO;
    @OneToMany
    private List<Article> articles = new ArrayList<>();

    //articulo vendible y producto es lo que esta en stock
    public BigDecimal getTotalPrice(){
        return articles.stream().map(Article::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
