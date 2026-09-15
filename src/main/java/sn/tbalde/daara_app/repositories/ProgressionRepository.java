package sn.tbalde.daara_app.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import sn.tbalde.daara_app.entities.Progression;

public interface ProgressionRepository extends JpaRepository<Progression, String> {

    Page<Progression> findBySourateContainsIgnoreCase(String keyword, Pageable pageable);

}
