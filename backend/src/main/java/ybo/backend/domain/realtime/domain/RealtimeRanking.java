package ybo.backend.domain.realtime.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RealtimeRanking {
    @Id @GeneratedValue
    @Column(name = "realtime_ranking_id")
    private Long id;
    private String team;
    private Integer ranking;
    private String gameNumber;
    private Integer winNumber;
    private Integer loseNumber;
    private Integer drawNumber;
    private Float winRate;
    private Float gameDiff;
    private String continuity;

    public static RealtimeRanking createRealtimeRanking(String team, Integer ranking, String gameNumber,
                                                        Integer winNumber, Integer loseNumber, Integer drawNumber,
                                                        Float winRate, Float gameDiff, String continuity){
        return RealtimeRanking.builder().team(team).ranking(ranking).gameNumber(gameNumber)
                .winNumber(winNumber).loseNumber(loseNumber).drawNumber(drawNumber)
                .winRate(winRate).gameDiff(gameDiff).continuity(continuity).build();
    }
}
