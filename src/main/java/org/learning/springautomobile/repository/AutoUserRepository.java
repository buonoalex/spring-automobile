package org.learning.springautomobile.repository;

import org.learning.springautomobile.model.AutoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutoUserRepository extends JpaRepository<AutoUser, Integer> {


    Optional<AutoUser> findByUsername(String username);
}
