package com.comit.bikerama.security.repository;

import java.util.Optional;
import com.comit.bikerama.security.entity.Role;
import com.comit.bikerama.security.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName name);


}
