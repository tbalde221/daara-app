package sn.tbalde.daara_app.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import sn.tbalde.daara_app.entities.Talibe;

public interface TalibeRepository extends JpaRepository<Talibe, String> {

    Page<Talibe> findByNomContainsIgnoreCaseOrPrenomContainsIgnoreCase(String keyword, String keyword2,
            Pageable pageable);

    List<Talibe> findByNomContainsIgnoreCase(String keyword);

}
