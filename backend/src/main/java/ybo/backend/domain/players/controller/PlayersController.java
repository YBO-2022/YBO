package ybo.backend.domain.players.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ybo.backend.domain.players.domain.Hitter;
import ybo.backend.domain.players.domain.Pitcher;
import ybo.backend.domain.players.dto.HitterDto;
import ybo.backend.domain.players.dto.HitterRankingDto;
import ybo.backend.domain.players.dto.PitcherDto;
import ybo.backend.domain.players.dto.PitcherRankingDto;
import ybo.backend.domain.players.service.PlayerService;
import ybo.backend.global.response.DefaultResponse;
import ybo.backend.global.response.StatusCode;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlayersController {

    private final PlayerService playerService;

    @GetMapping("/players/era")
    public DefaultResponse findPitchers() {
        List<Pitcher> pitchers_era = playerService.findAllPitchersERA();
        List<PitcherDto> pitcherDtos = pitchers_era.stream()
                .map(p -> PitcherDto.createDto(p))
                .collect(Collectors.toList());
        return DefaultResponse.res(StatusCode.OK, PlayersResponseMessage.PITCHER_SEND_SUCCESS, pitcherDtos);
    }

    @GetMapping("/players/ops")
    public DefaultResponse findHitters() {
        List<Hitter> hitters_ops = playerService.findAllHittersOPS();
        List<HitterDto> hitterDtos = hitters_ops.stream()
                .map(h -> HitterDto.createDto(h))
                .collect(Collectors.toList());
        return DefaultResponse.res(StatusCode.OK, PlayersResponseMessage.HITTER_SEND_SUCCESS, hitterDtos);
    }

    @GetMapping("/players/pitcherRanking")
    public DefaultResponse findPitcherRanking() {
        List<Pitcher> top3Win = playerService.findTop3Win();
        List<Pitcher> top3Era = playerService.findTop3Era();
        List<Pitcher> top3EarnedRun = playerService.findTop3EarnedRun();
        List<Pitcher> top3Save = playerService.findTop3Save();
        List<Pitcher> top3Hold = playerService.findTop3Hold();
        List<Pitcher> top3Strikeout = playerService.findTop3Strikeout();

        PitcherRankingDto pitcherRankingDto = new PitcherRankingDto(top3Win, top3Era, top3EarnedRun, top3Save, top3Hold, top3Strikeout);
        return DefaultResponse.res(StatusCode.OK, PlayersResponseMessage.PITCHER_RANK_SEND_SUCCESS, pitcherRankingDto);
    }

    @GetMapping("/players/hitterRanking")
    public DefaultResponse findHitterRanking() {
        List<Hitter> top3Ba = playerService.findTop3Ba();
        List<Hitter> top3Obp = playerService.findTop3Obp();
        List<Hitter> top3Slg = playerService.findTop3Slg();
        List<Hitter> top3Rbi = playerService.findTop3Rbi();
        List<Hitter> top3Homerun = playerService.findTop3Homerun();
        List<Hitter> top3Steal = playerService.findTop3Steal();

        HitterRankingDto hitterRankingDto = new HitterRankingDto(top3Ba, top3Obp, top3Slg, top3Rbi, top3Homerun, top3Steal);
        return DefaultResponse.res(StatusCode.OK, PlayersResponseMessage.HITTER_RANK_SEND_SUCCESS, hitterRankingDto);
    }

}
