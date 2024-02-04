package org.learning.springautomobile.repository;

import org.learning.springautomobile.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
}
