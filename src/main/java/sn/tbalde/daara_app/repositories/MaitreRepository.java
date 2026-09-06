package sn.tbalde.daara_app.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import sn.tbalde.daara_app.entities.Maitre;

public interface MaitreRepository extends JpaRepository<Maitre, String> {
    Page<Maitre> findByNomContainsIgnoreCase(String keyword, Pageable pageable);

    List<Maitre> findByNomContainsIgnoreCase(String keyword);

}
