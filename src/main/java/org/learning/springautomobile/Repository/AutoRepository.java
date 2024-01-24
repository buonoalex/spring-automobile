package org.learning.springautomobile.Repository;

import org.learning.springautomobile.Model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepository extends JpaRepository<Auto, Integer> {
}
