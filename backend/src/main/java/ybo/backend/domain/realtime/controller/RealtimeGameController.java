package ybo.backend.domain.realtime.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ybo.backend.domain.realtime.domain.RealtimeGame;
import ybo.backend.domain.realtime.domain.RealtimeRanking;
import ybo.backend.domain.realtime.dto.RealtimeGameDto;
import ybo.backend.domain.realtime.dto.RealtimeRankingDto;
import ybo.backend.domain.realtime.service.RealtimeGameService;
import ybo.backend.domain.realtime.service.RealtimeRankingService;
import ybo.backend.global.response.DefaultResponse;
import ybo.backend.global.response.StatusCode;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RealtimeGameController {

    private final RealtimeGameService realtimeGameService;

    @GetMapping("/realtime-game")
    public DefaultResponse findAllGames() {
        if (isTodayMonday()){
            return DefaultResponse.res(StatusCode.NO_CONTENT, RealtimeResponseMessage.REALTIME_GAME_MONDAY, "안녕!");
        }
        List<RealtimeGame> games = realtimeGameService.findAll();
        List<RealtimeGameDto> gameDtos = games.stream()
                .map(g -> RealtimeGameDto.createDto(g))
                .collect(Collectors.toList());
        return DefaultResponse.res(StatusCode.OK, RealtimeResponseMessage.REALTIME_RANKING_SEND_SUCCESS, gameDtos);
    }

    private boolean isTodayMonday(){
        ZoneId zoneId = ZoneId.of("Asia/Seoul");
        LocalDate date = LocalDate.now(zoneId);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return DayOfWeek.MONDAY==dayOfWeek;
    }
}
