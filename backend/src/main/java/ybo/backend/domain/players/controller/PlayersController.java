package ybo.backend.domain.players.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ybo.backend.domain.players.domain.Hitter;
import ybo.backend.domain.players.domain.Pitcher;
import ybo.backend.domain.players.service.PlayerService;
import ybo.backend.global.response.DefaultResponse;
import ybo.backend.global.response.StatusCode;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlayersController {

    private final PlayerService playerService;

    @GetMapping("/players/era")
    public DefaultResponse findPitchers() {
        List<Pitcher> pitchers_era = playerService.findAllPitchersERA();
        return DefaultResponse.res(StatusCode.OK, PlayersResponseMessage.PITCHER_SEND_SUCCESS, pitchers_era);
    }

    @GetMapping("/players/ops")
    public DefaultResponse findHitters() {
        List<Hitter> hitters_ops = playerService.findAllHittersOPS();
        return DefaultResponse.res(StatusCode.OK, PlayersResponseMessage.HITTER_SEND_SUCCESS, hitters_ops);
    }

}
