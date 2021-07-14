package com.comit.bikerama.repository;

import com.comit.bikerama.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/*
funciona para toda la interfaz aca, se ejecutatodo o nada si falla hace un rollback de que nos e pude guardar, para bases de datos transasionales
cuida de que se ejuten un conjunto de instrucciones por separado, inconveniente conto va para atras y devuelve exepcion
 */
@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User,Long> {

}
