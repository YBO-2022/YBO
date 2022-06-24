package ybo.backend.domain.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.teams.domain.SeasonHighLow;

public interface SeasonHighLowRepository extends JpaRepository<SeasonHighLow, Long> {
    SeasonHighLow findByTeam(String team);
}