package ybo.backend.domain.realtime.dto;

import lombok.Builder;
import lombok.Getter;
import ybo.backend.domain.realtime.domain.RealtimeRanking;

@Builder
@Getter
public class RealtimeRankingDto {
    private Integer ranking;
    private String team;
    private Integer gameNumber;
    private Integer winNumber;
    private Integer loseNumber;
    private Integer drawNumber;
    private Float winRate;
    private Float gameDiff;
    private String continuity;

    public static RealtimeRankingDto createDto(RealtimeRanking teamRank){
        return RealtimeRankingDto.builder().ranking(teamRank.getRanking())
                .team(teamRank.getTeam())
                .gameNumber(teamRank.getGameNumber())
                .winNumber(teamRank.getWinNumber())
                .loseNumber(teamRank.getLoseNumber())
                .drawNumber(teamRank.getDrawNumber())
                .winRate(teamRank.getWinRate())
                .gameDiff(teamRank.getGameDiff())
                .continuity(teamRank.getContinuity()).build();
    }
}
