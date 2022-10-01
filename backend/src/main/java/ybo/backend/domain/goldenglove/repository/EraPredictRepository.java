package ybo.backend.domain.goldenglove.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.goldenglove.domain.EraPredict;

import java.util.List;

public interface EraPredictRepository extends JpaRepository<EraPredict, Long> {
    List<EraPredict> findTop10ByOrderByPredictEraAsc();
}
