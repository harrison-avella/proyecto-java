package com.comit.bikerama.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date orderDate;
    private Date shippingDate;
    private String status;
    private String shippingAddress;
    private String payment; 
    private BigDecimal totalPayable;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<CartArticle> cartArticleList;

    @ManyToOne
    private User user;

}
