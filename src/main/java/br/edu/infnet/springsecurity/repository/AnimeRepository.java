package br.edu.infnet.springsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.springsecurity.model.Anime;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
    List<Anime> findByUserEmail(String userEmail);
}
