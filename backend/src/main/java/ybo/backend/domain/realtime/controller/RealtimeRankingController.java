package ybo.backend.domain.realtime.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ybo.backend.domain.realtime.domain.RealtimeRanking;
import ybo.backend.domain.realtime.service.RealtimeRankingService;
import ybo.backend.global.response.DefaultResponse;
import ybo.backend.global.response.StatusCode;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class RealtimeRankingController {

    private final RealtimeRankingService realtimeRankingService;

    @GetMapping("/realtime-ranking")
    public DefaultResponse findAllRankings() {
        List<RealtimeRanking> teams = realtimeRankingService.findAll();
        return DefaultResponse.res(StatusCode.OK, RealtimeResponseMessage.REALTIME_RANKING_SEND_SUCCESS, teams);
    }


}
