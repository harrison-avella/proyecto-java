package com.comit.bikerama.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.comit.bikerama.utils.StatusRole;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // lombok
@Setter
@NoArgsConstructor
@Entity(name = "users")
public class User implements UserDetails,Serializable {
   
   private static final Long serialVersionUID = 1L;

   @Id
   //@SequenceGenerator(name = "id", sequenceName = "id", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.IDENTITY /*SEQUENCE*/, generator = "id")
   @Column(name = "id", nullable = false, updatable = false)
   private Long id;
   @Column(name = "username", nullable = false, unique = true)
   private String username;
   @Column(name = "email", nullable = false, updatable = false, unique = true)
   private String email = "";
   @Column(name = "password", nullable = false)
   private String password;
   @Enumerated(EnumType.STRING)
   private StatusRole statusRole;
   private boolean locked;
   private boolean enabled;

   public User(String username, String email, String password) {
      this.username = username;
      this.email = email;
      this.password = password;
      this.statusRole = StatusRole.USER;
      this.locked = false;
      this.enabled = true;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "role_id")
   private Role role;

   private String fullName = "";
   private String address = "";
   private String phone = "";
   // private boolean active = Boolean.TRUE;
   // TODO: Revisar la relacion ManyToOne y ManyToMany

   @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
   private Cart cart;

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      SimpleGrantedAuthority authority = new SimpleGrantedAuthority(statusRole.name());
      return Collections.singletonList(authority);
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return !locked;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return enabled;
   }

   /*
    * @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade =
    * CascadeType.MERGE)
    * 
    * @JsonIgnore private Set<Role> roles = new HashSet<Role>();
    */

   // private Set<ShoppingCart> shopping = new HashSet<>();

   /*
    * public void activate() { this.active = Boolean.TRUE; }
    * 
    * public void deactivate() { this.active = Boolean.FALSE; }
    * 
    * public boolean haveRole(Role thisRole) { boolean haveRole = false; for (Role
    * role : roles) { if (role.getType().equals(thisRole)) { haveRole = true;
    * break; } } return haveRole; }
    */
   // @ManyToOne Ejemplo: muchas cordenadas pueden pertenecer a una embarcacion

   // @OneToMany Ejemplo: una flota tiene muchas embascaciones List<any>
}
