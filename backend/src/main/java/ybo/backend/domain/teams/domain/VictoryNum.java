package ybo.backend.domain.teams.domain;

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
public class VictoryNum {

    @Id @GeneratedValue
    @Column(name = "victory_num_id")
    private Long id;

    private String team;
    private Integer victoryNum;

    public static VictoryNum createVictoryNum(String team, Integer victoryNum){
        return VictoryNum.builder().team(team).victoryNum(victoryNum).build();
    }
}
