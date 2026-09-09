package sn.tbalde.daara_app.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import sn.tbalde.daara_app.entities.Classe;

public interface ClasseRepository extends JpaRepository<Classe, String> {

    Page<Classe> findByLibelleContainsIgnoreCase(String keyword, Pageable pageable);

    List<Classe> findByLibelleContainsIgnoreCase(String keyword);

}
