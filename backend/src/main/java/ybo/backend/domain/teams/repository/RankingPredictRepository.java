package ybo.backend.domain.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.teams.domain.RankingPredict;

public interface RankingPredictRepository extends JpaRepository<RankingPredict, Long> {
}