package ybo.backend.domain.goldenglove.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ybo.backend.domain.goldenglove.domain.EraPredict;
import ybo.backend.domain.goldenglove.domain.OpsPredict;
import ybo.backend.domain.goldenglove.domain.SquadPredict;
import ybo.backend.domain.goldenglove.repository.EraPredictRepository;
import ybo.backend.domain.goldenglove.repository.OpsPredictRepository;
import ybo.backend.domain.goldenglove.repository.SquadPredictRepository;

import java.util.List;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class GoldengloveService {

    private final EraPredictRepository eraPredictRepository;
    private final OpsPredictRepository opsPredictRepository;
    private final SquadPredictRepository squadPredictRepository;

    public List<EraPredict> findEraPrediction() {
        return eraPredictRepository.findTop10ByOrderByPredictEraAsc();
    }

    public List<OpsPredict> findOpsPrediction() {
        return opsPredictRepository.findTop10ByOrderByPredictOpsDesc();
    }

    public List<SquadPredict> findSquadPrediction() {
        return squadPredictRepository.findAll();
    }

}
