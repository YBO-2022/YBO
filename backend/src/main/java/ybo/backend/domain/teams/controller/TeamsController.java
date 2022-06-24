package ybo.backend.domain.teams.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ybo.backend.domain.teams.domain.War;
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

    @GetMapping("/teams/{teamId}/war")
    public DefaultResponse findTeam(@PathVariable("teamId") Integer teamId) {
        String teamName = teamsService.findTeamName(teamId);

        List<War> warTop5 = teamsService.findTop5War(teamName);
        List<War> warLow5 = teamsService.findLow5War(teamName);

        WarDto warDto = new WarDto(warTop5, warLow5);
        return DefaultResponse.res(StatusCode.OK, TeamsResponseMessage.TEAMS_WAR_SEND_SUCCESS, warDto);
    }
}
