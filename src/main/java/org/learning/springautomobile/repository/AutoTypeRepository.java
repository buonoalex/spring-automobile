package org.learning.springautomobile.repository;

import org.learning.springautomobile.model.AutoType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoTypeRepository extends JpaRepository<AutoType, Integer> {
}
