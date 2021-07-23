package com.comit.bikerama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import com.comit.bikerama.models.User;

/*
funciona para toda la interfaz aca, se ejecutatodo o nada si falla hace un rollback de que nos e pude guardar, para bases de datos transasionales
cuida de que se ejuten un conjunto de instrucciones por separado, inconveniente conto va para atras y devuelve exepcion
 */
@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);
    User findByEmail(String email);
}
