package ybo.backend.domain.teams.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RankPredict {
    @Id @GeneratedValue
    @Column(name = "rank_predict_id")
    @JsonIgnore
    private Integer rankPredictId;
    private String team;
    @JsonIgnore
    private Float winRate;
    private Float predictWinRate;
}
