package ybo.backend.domain.teams.domain;

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
public class SeasonHighLow {

    @Id @GeneratedValue
    @Column(name = "season_high_low_id")
    private Long id;

    private String team;
    private Integer seasonHigh;
    private Integer seasonLow;
}
