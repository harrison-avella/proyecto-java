package com.comit.bikerama.service;

import java.util.List;
import java.util.Optional;

import com.comit.bikerama.domain.Role;

public interface RoleService {

    Role findByName(String name);

    List<Role> findAll();

    Optional<Role> findById(Long id);

    Role save(Role role);

    Role update(Role role);

    String deleteById(Long id);

}
