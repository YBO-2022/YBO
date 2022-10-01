package ybo.backend.domain.teams.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class RankingHistory {
    @Id @GeneratedValue
    @Column(name = "ranking_history_id")
    @JsonIgnore
    private Integer id;
    private String team;
    private Integer year;
    private Integer ranking;

    public static RankingHistory createRankingHistory(String team, Integer year, Integer ranking){
        return RankingHistory.builder().team(team).year(year).ranking(ranking).build();
    }
}
