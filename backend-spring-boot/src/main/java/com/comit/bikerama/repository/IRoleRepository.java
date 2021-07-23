package com.comit.bikerama.repository;

import javax.transaction.Transactional;

import com.comit.bikerama.domain.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface IRoleRepository extends JpaRepository<Role, Long> {
    
    Role findByName(String name);
}
