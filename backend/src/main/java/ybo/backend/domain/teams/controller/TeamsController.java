package ybo.backend.domain.teams.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ybo.backend.domain.realtime.service.RealtimeRankingService;
import ybo.backend.domain.teams.domain.*;
import ybo.backend.domain.teams.dto.TeamInfoDto;
import ybo.backend.domain.teams.dto.WarDto;
import ybo.backend.domain.teams.service.TeamsService;
import ybo.backend.global.response.DefaultResponse;
import ybo.backend.global.response.StatusCode;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TeamsController {

    private final TeamsService teamsService;
    private final RealtimeRankingService realtimeRankingService;

    @GetMapping("/teams/predictRank")
    public DefaultResponse predictRank() {
        List<RankPredict> rankPredict = teamsService.findRankPredict();
        return DefaultResponse.res(StatusCode.OK, TeamsResponseMessage.RANK_PREDICT_SEND_SUCCESS, rankPredict);
    }

    @GetMapping("/teams/{teamId}/teamInfo")
    public DefaultResponse findTeamInfo(@PathVariable("teamId") Integer teamId) {
        String teamName = teamsService.findTeamName(teamId);

        VictoryNum victoryNum = teamsService.findVictoryNum(teamName);

        ybo.backend.domain.realtime.domain.RealtimeRanking byTeam = realtimeRankingService.findByTeam(teamName);
        Integer ranking = byTeam.getRanking();

        SeasonHighLow seasonHighLow = teamsService.findSeasonHighLow(teamName);

        TeamInfoDto teamInfoDto = new TeamInfoDto(victoryNum, ranking, seasonHighLow);
        return DefaultResponse.res(StatusCode.OK, TeamsResponseMessage.TEAMS_INFO_SEND_SUCCESS, teamInfoDto);
    }

    @GetMapping("/teams/{teamId}/firstTeam")
    public DefaultResponse findFirstTeam(@PathVariable("teamId") Integer teamId) {
        String teamName = teamsService.findTeamName(teamId);

        FirstTeam firstTeam = teamsService.findFirstTeam(teamName);
        return DefaultResponse.res(StatusCode.OK, TeamsResponseMessage.TEAMS_FT_SEND_SUCCESS, firstTeam);
    }

    @GetMapping("/teams/{teamId}/war")
    public DefaultResponse findTeamWar(@PathVariable("teamId") Integer teamId) {
        String teamName = teamsService.findTeamName(teamId);

        List<WarList> warTop5 = teamsService.findTop5War(teamName);
        List<WarList> warLow5 = teamsService.findLow5War(teamName);

        WarDto warDto = new WarDto(warTop5, warLow5);
        return DefaultResponse.res(StatusCode.OK, TeamsResponseMessage.TEAMS_WAR_SEND_SUCCESS, warDto);
    }

    @GetMapping("/teams/{teamId}/rankingHistory")
    public DefaultResponse findRankingHistory(@PathVariable("teamId") Integer teamId) {
        String teamName = teamsService.findTeamName(teamId);

        List<RankingHistory> rankingHistory = teamsService.findRankingHistory(teamName);
        return DefaultResponse.res(StatusCode.OK, TeamsResponseMessage.TEAMS_RH_SEND_SUCCESS, rankingHistory);
    }
}
