package ybo.backend.domain.players.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.players.domain.Hitter;
import ybo.backend.domain.players.domain.Pitcher;


public interface HitterRepository extends JpaRepository<Hitter, Long>{

}