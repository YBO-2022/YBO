package ybo.backend.domain.players.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import ybo.backend.domain.players.domain.Hitter;

@Builder
@Getter
public class HitterDto {
    private String name;
    private String team;
    private Float ops;
    private Integer games; // 게임수
    private Integer pa; // 타석
    private Float ba; // 타율
    private Integer hit; // 안타
    private Integer homerun; // 홈런
    private Integer rbi; // 타점
    private Integer steal; // 도루
    private Integer strikeout; // 삼진
    private Integer dp; // 병살
    private Float war; // WAR

    public static HitterDto createDto(Hitter hitter) {
        return HitterDto.builder().name(hitter.getName())
                .team(hitter.getTeam())
                .ops(hitter.getOps())
                .games(hitter.getGames())
                .pa(hitter.getPa())
                .ba(hitter.getBa())
                .hit(hitter.getHit())
                .homerun(hitter.getHomerun())
                .rbi(hitter.getRbi())
                .steal(hitter.getSteal())
                .strikeout(hitter.getStrikeout())
                .dp(hitter.getDp())
                .war(hitter.getWar()).build();
    }
}

/*
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
 */