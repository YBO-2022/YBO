package ybo.backend.domain.goldenglove.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.goldenglove.domain.SquadPredict;

public interface SquadPredictRepository extends JpaRepository<SquadPredict, Long> {
}
