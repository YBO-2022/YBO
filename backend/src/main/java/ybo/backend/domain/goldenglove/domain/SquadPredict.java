package ybo.backend.domain.goldenglove.domain;

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
public class SquadPredict {
    @Id @GeneratedValue
    @Column(name = "squad_predict_id")
    private Long id;
    private String name;
    private String team;
    private String position;

    public static SquadPredict createSquadPredict(String name, String team, String position){
        return SquadPredict.builder().name(name).team(team).position(position).build();
    }
}
