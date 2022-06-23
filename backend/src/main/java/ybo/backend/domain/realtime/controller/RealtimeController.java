package ybo.backend.domain.realtime.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ybo.backend.domain.realtime.domain.RealtimeRanking;
import ybo.backend.domain.realtime.dto.RealtimeRankingDto;
import ybo.backend.domain.realtime.service.RealtimeRankingService;
import ybo.backend.domain.test.controller.TextResponseMessage;
import ybo.backend.global.response.DefaultResponse;
import ybo.backend.global.response.StatusCode;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RealtimeController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${flask.server.url}")
    private String flaskServerUrl;

    private final RealtimeRankingService realtimeRankingService;

    @GetMapping("/realtime-ranking")
    public DefaultResponse findAllTexts() {
        List<RealtimeRanking> teams = realtimeRankingService.findAll();
        List<RealtimeRankingDto> teamDtos = teams.stream()
                .map(t -> RealtimeRankingDto.createDto(t))
                .collect(Collectors.toList());
        return DefaultResponse.res(StatusCode.OK, RealtimeResponseMessage.REALTIME_RANKING_SEND_SUCCESS, teamDtos);
    }
}
