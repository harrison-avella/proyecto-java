package com.comit.bikerama.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToOne /* (mappedBy = "cart") */
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CartArticle> cartArticleList = new ArrayList<>();

    // private Date dateAdded;//fecha compra
    // private Date dateShipping; //fecha de envio
    // @Enumerated(EnumType.STRING)
    // private StatusShippingCart statusShippingCart = StatusShippingCart.ACTIVO;

    // articulo vendible y producto es lo que esta en stock
    public BigDecimal getTotalPayable() {
        return cartArticleList.stream().map(a -> a.getTotalPrice()).reduce(BigDecimal.ZERO,
                BigDecimal::add);
    }

}
