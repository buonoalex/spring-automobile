package org.learning.springautomobile.repository;

import org.learning.springautomobile.model.Auto;
import org.learning.springautomobile.model.AutoType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Integer> {

    List<Auto> findByNameContaining(String searchName);
    /*List<Auto> findByAutoType(AutoType searchName);*/

    List<Auto> findByName(String searchName);
    List<Auto> findByLogo(String searchName);
    List<Auto> findByMarca(String searchName);
}
