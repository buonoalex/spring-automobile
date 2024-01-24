package org.learning.springautomobile.repository;

import org.learning.springautomobile.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepository extends JpaRepository<Auto, Integer> {
}
