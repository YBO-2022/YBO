package ybo.backend.domain.teams.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RankingPredict {
    @Id @GeneratedValue
    @Column(name = "ranking_predict_id")
    @JsonIgnore
    private Integer id;
    private String team;
    @JsonIgnore
    private Float winRate;
    private Float predictWinRate;

    public static RankingPredict createRankPredict(String team, Float winRate, Float predictWinRate){
        return RankingPredict.builder().team(team).winRate(winRate).predictWinRate(predictWinRate).build();
    }
}
