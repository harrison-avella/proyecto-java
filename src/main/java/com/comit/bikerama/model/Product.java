package com.comit.bikerama.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product implements Serializable {
    private static final long serialVersionUID= 1L;

    private Long id;
    private BigDecimal cantMin = BigDecimal.TEN;
    private BigDecimal cantCurrent = BigDecimal.ZERO;
    private String name ="";
    private String description ="";
    private BigDecimal price = BigDecimal.ZERO;
    private String supplier = "";
    private BigDecimal iva = new BigDecimal("1.21");

    private BigDecimal getPrice(){
        return price;
    }

    public  BigDecimal getPriceWithIva(){
        return price.multiply(iva);
    }

    public BigDecimal getPriceOutOfIva(){
        return getPrice();
    }

    public boolean isThereStored(){
        return cantCurrent.compareTo(cantMin) <=0; // da cero si son iguales -1 si es menos y 1 si es mayor
    }
}
