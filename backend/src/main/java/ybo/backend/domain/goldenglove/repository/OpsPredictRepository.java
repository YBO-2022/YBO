package ybo.backend.domain.goldenglove.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.goldenglove.domain.OpsPredict;

import java.util.List;

public interface OpsPredictRepository extends JpaRepository<OpsPredict, Long> {
    List<OpsPredict> findTop10ByOrderByPredictOpsDesc();
}
