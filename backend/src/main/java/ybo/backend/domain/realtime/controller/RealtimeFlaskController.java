package ybo.backend.domain.realtime.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ybo.backend.domain.realtime.dto.RealtimeGameDto;
import ybo.backend.domain.realtime.dto.RealtimeRankingDto;
import ybo.backend.global.response.DefaultResponse;
import ybo.backend.global.response.StatusCode;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RealtimeFlaskController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${flask.server.url}")
    private String flaskServerUrl;

    //@GetMapping("/realtime-ranking")
    public DefaultResponse getRealtimeRanking() {
        DefaultResponse response = restTemplate.getForObject(flaskServerUrl+"/rank", DefaultResponse.class);
        List<RealtimeRankingDto> data = (List<RealtimeRankingDto>) response.getData();
        return DefaultResponse.res(StatusCode.OK, RealtimeResponseMessage.REALTIME_RANKING_SEND_SUCCESS, data);
    }


    //@GetMapping("/realtime-game")
    public DefaultResponse getRealtimeGame() {
        return requestRealtimeGame("/game");
    }

    //@GetMapping("/realtime-game/monday")
    public DefaultResponse getRealtimeGameMonday() {
        return requestRealtimeGame("/game/monday");
    }

    private DefaultResponse requestRealtimeGame(String apiUrl){
        DefaultResponse response = restTemplate.getForObject(flaskServerUrl+apiUrl, DefaultResponse.class);
        int flaskStatusCode = response.getStatusCode();
        if (flaskStatusCode==StatusCode.NOT_FOUND){
            return DefaultResponse.res(StatusCode.NO_CONTENT, response.getMessage(), "안녕!");
        }
        List<RealtimeGameDto> data = (List<RealtimeGameDto>) response.getData();
        return DefaultResponse.res(StatusCode.OK, RealtimeResponseMessage.REALTIME_GAME_SEND_SUCCESS, data);
    }
}