package ybo.backend.domain.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.teams.domain.VictoryNum;

public interface VictoryNumRepository extends JpaRepository<VictoryNum, Long> {
    VictoryNum findByTeam(String team);
}
