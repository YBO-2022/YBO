package ybo.backend.domain.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.teams.domain.RankPredict;

public interface RankPredictRepository extends JpaRepository<RankPredict, Long> {
}