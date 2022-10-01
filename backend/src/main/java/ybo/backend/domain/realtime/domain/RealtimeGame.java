package ybo.backend.domain.realtime.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ybo.backend.domain.players.domain.Hitter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RealtimeGame {
    @Id @GeneratedValue
    @Column(name = "realtime_game_id")
    @JsonIgnore
    private Long id;
    private String gameState;
    private String leftTeam;
    private String rightTeam;
    private Integer leftScore;
    private Integer rightScore;
    private String state;
    private String leftPitcher;
    private String rightPitcher;

    public static RealtimeGame createRealTimeGame(String gameState, String leftTeam, String rightTeam, Integer leftScore,
                                                  Integer rightScore, String state, String leftPitcher, String rightPitcher){
        return RealtimeGame.builder().gameState(gameState).leftTeam(leftTeam).rightTeam(rightTeam).leftScore(leftScore)
                .rightScore(rightScore).state(state).leftPitcher(leftPitcher).rightPitcher(rightPitcher).build();
    }
}
