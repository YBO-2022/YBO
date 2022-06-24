package ybo.backend.domain.teams.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Id
    @GeneratedValue

    @Column(name = "realtime_ranking_id")
    @JsonIgnore
    private Integer rankingHistoryId;
    @Column(name = "continuity")
    @JsonIgnore
    private Integer continuity;
    @Column(name = "draw_number")
    @JsonIgnore
    private Integer drawNumber;
    @Column(name = "game_diff")
    @JsonIgnore
    private Integer gameDiff;
    @Column(name = "lose_number")
    @JsonIgnore
    private Integer loseNumber;

    @Column(name = "ranking")
    private Integer ranking;
    @Column(name = "team")
    private String team;

    @Column(name = "win_number")
    @JsonIgnore
    private Integer winNumber;
    @Column(name = "win_rate")
    @JsonIgnore
    private Integer winRate;
    @Column(name = "game_number")
    @JsonIgnore
    private Integer gameNumber;

}
