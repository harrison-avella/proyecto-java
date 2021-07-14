package com.comit.bikerama.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date orderDate;
    private Date shippingDate;
    private String status;
    private String ShippingAddress;
    private String payment; 

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Article> articles;


}
