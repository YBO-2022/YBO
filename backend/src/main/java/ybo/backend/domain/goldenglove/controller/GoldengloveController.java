package ybo.backend.domain.goldenglove.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ybo.backend.domain.goldenglove.domain.EraPredict;
import ybo.backend.domain.goldenglove.domain.OpsPredict;
import ybo.backend.domain.goldenglove.domain.SquadPredict;
import ybo.backend.domain.goldenglove.service.GoldengloveService;
import ybo.backend.global.response.DefaultResponse;
import ybo.backend.global.response.StatusCode;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GoldengloveController {

    private final GoldengloveService goldengloveService;

    @GetMapping("/goldenglove/era")
    public DefaultResponse findEra() {
        List<EraPredict> eraPredictPredictionTop10 = goldengloveService.findEraPrediction();
        return DefaultResponse.res(StatusCode.OK, GoldengloveResponseMessage.GOLDENGLOVE_SEND_SUCCESS, eraPredictPredictionTop10);
    }

    @GetMapping("/goldenglove/ops")
    public DefaultResponse findOps() {
        List<OpsPredict> opsPredictPredictionTop10 = goldengloveService.findOpsPrediction();
        return DefaultResponse.res(StatusCode.OK, GoldengloveResponseMessage.GOLDENGLOVE_SEND_SUCCESS, opsPredictPredictionTop10);
    }

    @GetMapping("/goldenglove/squad")
    public DefaultResponse findSquad() {
        List<SquadPredict> squadPrediction = goldengloveService.findSquadPrediction();
        return DefaultResponse.res(StatusCode.OK, GoldengloveResponseMessage.GOLDENGLOVE_SEND_SUCCESS, squadPrediction);
    }

}