package ybo.backend.domain.realtime.domain;

import lombok.AllArgsConstructor;
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
public class RealtimeRanking {
    @Id @GeneratedValue
    @Column(name = "realtime_ranking_id")
    private Integer id;
    private Integer ranking;
    private String team;
    private String gameNumber;
    private Integer winNumber;
    private Integer loseNumber;
    private Integer drawNumber;
    private Float winRate;
    private Float gameDiff;
    private String continuity;
}
