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
public class RankingHistory {
    @Id @GeneratedValue
    @Column(name = "ranking_history_id")
    @JsonIgnore
    private Integer rankingHistoryId;
    private Integer year;
    private String team;
    private Integer ranking;
}
