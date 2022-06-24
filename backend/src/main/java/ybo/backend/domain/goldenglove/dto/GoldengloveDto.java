package ybo.backend.domain.goldenglove.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ybo.backend.domain.goldenglove.domain.EraPredict;
import ybo.backend.domain.goldenglove.domain.OpsPredict;
import ybo.backend.domain.goldenglove.domain.SquadPredict;

import java.util.List;

@AllArgsConstructor
public class GoldengloveDto {
    @JsonProperty("era")
    private List<EraPredict> eraPredictPredictionTop10;
    @JsonProperty("ops")
    private List<OpsPredict> opsPredictPredictionTop10;
    @JsonProperty("squad")
    private List<SquadPredict> squadPrediction;
}
