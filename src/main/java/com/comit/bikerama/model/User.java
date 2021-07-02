package com.comit.bikerama.models;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {
 //Serializable es una interface permite a la clase guardar en un archivo y traerlo de vuelta
    private static final long serialVersionUID = 1L;

    @Id
    @Getter //lombok
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String fullName;

    //@ManyToOne Ejemplo: muchas cordenadas pueden pertenecer a una embarcacion

}
