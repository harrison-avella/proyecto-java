package com.comit.bikerama.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter // lombok
@Setter
@NoArgsConstructor
@Entity(name = "users")
public class User implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id", nullable = false, updatable = false)
   private long id;
   private String userName;
   private String password;
   private String fullName = "";
   @Column(name = "email", nullable = false, updatable = false)
   private String email = "";
   private String address = "";
   private String phone = "";
   //private boolean active = Boolean.TRUE;
   
   @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
   @JsonIgnore
   private Set<Role> roles = new HashSet<Role>();
   
   @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
   private Cart cart;
   //private Set<ShoppingCart> shopping = new HashSet<>();

   /*
   public void activate() {
      this.active = Boolean.TRUE;
   }

   public void deactivate() {
      this.active = Boolean.FALSE;
   }

   public boolean haveRole(Role thisRole) {
      boolean haveRole = false;
      for (Role role : roles) {
         if (role.getType().equals(thisRole)) {
            haveRole = true;
            break;
         }
      }
      return haveRole;
   }
*/
   // @ManyToOne Ejemplo: muchas cordenadas pueden pertenecer a una embarcacion

   // @OneToMany Ejemplo: una flota tiene muchas embascaciones List<any>
}
