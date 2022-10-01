package ybo.backend.domain.goldenglove.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ybo.backend.domain.goldenglove.domain.EraPredict;
import ybo.backend.domain.goldenglove.domain.OpsPredict;
import ybo.backend.domain.goldenglove.domain.SquadPredict;
import ybo.backend.domain.goldenglove.repository.EraRepository;
import ybo.backend.domain.goldenglove.repository.OpsRepository;
import ybo.backend.domain.goldenglove.repository.SquadRepository;

import java.util.List;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class GoldengloveService {

    private final EraRepository eraRepository;
    private final OpsRepository opsRepository;
    private final SquadRepository squadRepository;

    public List<EraPredict> findEraPrediction() {
        return eraRepository.findTop10ByOrderByPredictEraAsc();
    }

    public List<OpsPredict> findOpsPrediction() {
        return opsRepository.findTop10ByOrderByPredictOpsDesc();
    }

    public List<SquadPredict> findSquadPrediction() {
        return squadRepository.findAll();
    }

}
