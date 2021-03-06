package com.comit.bikerama.domain;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Product implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name = "";
    private String description = "";
    private BigDecimal price = BigDecimal.ZERO;
    private Integer stock = 0;
    private String supplier = "";
    private String image = "";
}

// private BigDecimal cantMin = BigDecimal.TEN;
// private BigDecimal cantCurrent = BigDecimal.ZERO;
// private BigDecimal iva = new BigDecimal("1.21");

/*
 * private BigDecimal getPrice(){ return price; }
 * 
 * public BigDecimal getPriceWithIva(){ return price.multiply(iva); }
 * 
 * public BigDecimal getPriceOutOfIva(){ return getPrice(); }
 * 
 * public boolean isThereStored(){ return cantCurrent.compareTo(cantMin) <=0; }
 * // el compareTo da cero si son iguales -1 si es menos y 1 si es mayor
 * 
 */
