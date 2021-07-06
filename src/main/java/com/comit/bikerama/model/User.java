package com.comit.bikerama.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter //lombok
@Setter
@NoArgsConstructor
@Entity (name = "users")
public class User implements Serializable {
 //Serializable es una interface permite a la clase guardar en un archivo y traerlo de vuelta
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //private String userName;
    private String fullName = "";
    private String email = "";
    private String address = "";
    private String whatsapp = "";
    @OneToMany
    private Set<Role> roles = new HashSet<Role>();
    private boolean active = Boolean.TRUE;
    @OneToMany
    private Set<ShoppingCart> shopping = new HashSet<>();

   public void activate(){
      this.active = Boolean.TRUE;
   }

   public void deactivate(){
      this.active = Boolean.FALSE;
   }

   public boolean haveRole(Role thisRole){
      boolean haveRole = false;
      for(Role role: roles){
         if (role.getType().equals(thisRole)){
            haveRole = true;
            break;
         }
      }
      return haveRole;
   }

    //@ManyToOne Ejemplo: muchas cordenadas pueden pertenecer a una embarcacion


   //@OneToMany Ejemplo: una flota tiene muchas embascaciones List<any>
}
