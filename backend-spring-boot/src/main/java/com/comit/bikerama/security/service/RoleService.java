package com.comit.bikerama.security.service;

import java.util.Optional;
import com.comit.bikerama.security.entity.Role;
import com.comit.bikerama.security.enums.RoleName;
import com.comit.bikerama.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> findByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    public void save(Role role) {
        roleRepository.save(role);
    }
}
