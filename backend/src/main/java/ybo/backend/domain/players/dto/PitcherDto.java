package ybo.backend.domain.players.dto;

import lombok.Builder;
import lombok.Getter;
import ybo.backend.domain.players.domain.Hitter;
import ybo.backend.domain.players.domain.Pitcher;

@Builder
@Getter
public class PitcherDto {
    private String name;
    private String team;
    private Float era;
    private Float war;
    private Integer win;
    private Integer lose;
    private Float inning;
    private Integer runs;
    private Integer earnedRun;
    private Integer hit;
    private Integer homerun;
    private Integer bb;
    private Integer strikeout;

    public static PitcherDto createDto(Pitcher pitcher) {
        return PitcherDto.builder().name(pitcher.getName())
                .team(pitcher.getTeam())
                .era(pitcher.getEra())
                .war(pitcher.getWar())
                .win(pitcher.getWin())
                .lose(pitcher.getLose())
                .inning(pitcher.getInning())
                .runs(pitcher.getRuns())
                .earnedRun(pitcher.getEarnedRun())
                .hit(pitcher.getHit())
                .homerun(pitcher.getHomerun())
                .bb(pitcher.getBb())
                .strikeout(pitcher.getStrikeout()).build();
    }
}
