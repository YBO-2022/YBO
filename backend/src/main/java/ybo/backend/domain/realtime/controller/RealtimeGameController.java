package ybo.backend.domain.realtime.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ybo.backend.domain.realtime.domain.RealtimeGame;
import ybo.backend.domain.realtime.service.RealtimeGameService;
import ybo.backend.global.response.DefaultResponse;
import ybo.backend.global.response.StatusCode;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class RealtimeGameController {

    private final RealtimeGameService realtimeGameService;

    @GetMapping("/realtime-game")
    public DefaultResponse findAllGames() {
        if (isTodayMonday()){
            return DefaultResponse.res(StatusCode.NO_CONTENT, RealtimeResponseMessage.REALTIME_GAME_MONDAY);
        }
        List<RealtimeGame> games = realtimeGameService.findAll();
        return DefaultResponse.res(StatusCode.OK, RealtimeResponseMessage.REALTIME_GAME_SEND_SUCCESS, games);
    }

    private boolean isTodayMonday(){
        ZoneId zoneId = ZoneId.of("Asia/Seoul");
        LocalDate date = LocalDate.now(zoneId);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return DayOfWeek.MONDAY==dayOfWeek;
    }
}
