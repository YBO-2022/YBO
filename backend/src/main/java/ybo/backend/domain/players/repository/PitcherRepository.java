package ybo.backend.domain.players.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.players.domain.Pitcher;


public interface PitcherRepository extends JpaRepository<Pitcher, Long> {

}
