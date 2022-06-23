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
public class RealtimeGame {
    @Id @GeneratedValue
    @Column(name = "realtime_game_id")
    private Integer id;
    private String leftTeam;
    private String rightTeam;
    private String leftScore;
    private String rightScore;
    private String state;
    private String leftPitcher;
    private String rightPitcher;
}
