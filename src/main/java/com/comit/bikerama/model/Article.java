package com.comit.bikerama.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

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
    @ManyToOne
    private Product product;

    public BigDecimal getTotalPrice(){
        return priceUnit.multiply(cant);
    }
}
