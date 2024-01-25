package org.learning.springautomobile.repository;

import org.learning.springautomobile.model.AutoType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoTypeRepository extends JpaRepository<AutoType, Integer> {
   /* List<AutoType> findByNameContaining(String searchName);*/
}
